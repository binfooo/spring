

package org.springframework.instrument.classloading;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the {@link ReflectiveLoadTimeWeaver} class.
 *
 * @author Rick Evans
 * @author Chris Beams
 */
public class ReflectiveLoadTimeWeaverTests {

	@Test(expected = IllegalArgumentException.class)
	public void testCtorWithNullClassLoader() {
		new ReflectiveLoadTimeWeaver(null);
	}

	@Test(expected = IllegalStateException.class)
	public void testCtorWithClassLoaderThatDoesNotExposeAnAddTransformerMethod() {
		new ReflectiveLoadTimeWeaver(getClass().getClassLoader());
	}

	@Test
	public void testCtorWithClassLoaderThatDoesNotExposeAGetThrowawayClassLoaderMethodIsOkay() {
		JustAddTransformerClassLoader classLoader = new JustAddTransformerClassLoader();
		ReflectiveLoadTimeWeaver weaver = new ReflectiveLoadTimeWeaver(classLoader);
		weaver.addTransformer(new ClassFileTransformer() {
			@Override
			public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
				return "CAFEDEAD".getBytes();
			}
		});
		assertEquals(1, classLoader.getNumTimesGetThrowawayClassLoaderCalled());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddTransformerWithNullTransformer() {
		new ReflectiveLoadTimeWeaver(new JustAddTransformerClassLoader()).addTransformer(null);
	}

	@Test
	public void testGetThrowawayClassLoaderWithClassLoaderThatDoesNotExposeAGetThrowawayClassLoaderMethodYieldsFallbackClassLoader() {
		ReflectiveLoadTimeWeaver weaver = new ReflectiveLoadTimeWeaver(new JustAddTransformerClassLoader());
		ClassLoader throwawayClassLoader = weaver.getThrowawayClassLoader();
		assertNotNull(throwawayClassLoader);
	}

	@Test
	public void testGetThrowawayClassLoaderWithTotallyCompliantClassLoader() {
		TotallyCompliantClassLoader classLoader = new TotallyCompliantClassLoader();
		ReflectiveLoadTimeWeaver weaver = new ReflectiveLoadTimeWeaver(classLoader);
		ClassLoader throwawayClassLoader = weaver.getThrowawayClassLoader();
		assertNotNull(throwawayClassLoader);
		assertEquals(1, classLoader.getNumTimesGetThrowawayClassLoaderCalled());
	}


	public static class JustAddTransformerClassLoader extends ClassLoader {

		private int numTimesAddTransformerCalled = 0;


		public int getNumTimesGetThrowawayClassLoaderCalled() {
			return this.numTimesAddTransformerCalled;
		}


		public void addTransformer(ClassFileTransformer transformer) {
			++this.numTimesAddTransformerCalled;
		}

	}


	public static final class TotallyCompliantClassLoader extends JustAddTransformerClassLoader {

		private int numTimesGetThrowawayClassLoaderCalled = 0;


		@Override
		public int getNumTimesGetThrowawayClassLoaderCalled() {
			return this.numTimesGetThrowawayClassLoaderCalled;
		}


		public ClassLoader getThrowawayClassLoader() {
			++this.numTimesGetThrowawayClassLoaderCalled;
			return getClass().getClassLoader();
		}

	}

}
