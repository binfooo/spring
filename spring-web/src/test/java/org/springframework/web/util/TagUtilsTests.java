

package org.springframework.web.util;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the {@link TagUtils} class.
 *
 * @author Alef Arendsen
 * @author Rick Evans
 */
public class TagUtilsTests {

	@Test
	public void getScopeSunnyDay() {
		assertEquals("page", TagUtils.SCOPE_PAGE);
		assertEquals("application", TagUtils.SCOPE_APPLICATION);
		assertEquals("session", TagUtils.SCOPE_SESSION);
		assertEquals("request", TagUtils.SCOPE_REQUEST);

		assertEquals(PageContext.PAGE_SCOPE, TagUtils.getScope("page"));
		assertEquals(PageContext.REQUEST_SCOPE, TagUtils.getScope("request"));
		assertEquals(PageContext.SESSION_SCOPE, TagUtils.getScope("session"));
		assertEquals(PageContext.APPLICATION_SCOPE, TagUtils.getScope("application"));

		// non-existent scope
		assertEquals("TagUtils.getScope(..) with a non-existent scope argument must " +
				"just return the default scope (PageContext.PAGE_SCOPE).", PageContext.PAGE_SCOPE,
				TagUtils.getScope("bla"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void getScopeWithNullScopeArgument() {
		TagUtils.getScope(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void hasAncestorOfTypeWhereAncestorTagIsNotATagType() throws Exception {
		assertFalse(TagUtils.hasAncestorOfType(new TagSupport(), String.class));
	}

	@Test(expected = IllegalArgumentException.class)
	public void hasAncestorOfTypeWithNullTagArgument() throws Exception {
		assertFalse(TagUtils.hasAncestorOfType(null, TagSupport.class));
	}

	@Test(expected = IllegalArgumentException.class)
	public void hasAncestorOfTypeWithNullAncestorTagClassArgument() throws Exception {
		assertFalse(TagUtils.hasAncestorOfType(new TagSupport(), null));
	}

	@Test
	public void hasAncestorOfTypeTrueScenario() throws Exception {
		Tag a = new TagA();
		Tag b = new TagB();
		Tag c = new TagC();

		a.setParent(b);
		b.setParent(c);

		assertTrue(TagUtils.hasAncestorOfType(a, TagC.class));
	}

	@Test
	public void hasAncestorOfTypeFalseScenario() throws Exception {
		Tag a = new TagA();
		Tag b = new TagB();
		Tag anotherB = new TagB();

		a.setParent(b);
		b.setParent(anotherB);

		assertFalse(TagUtils.hasAncestorOfType(a, TagC.class));
	}

	@Test
	public void hasAncestorOfTypeWhenTagHasNoParent() throws Exception {
		assertFalse(TagUtils.hasAncestorOfType(new TagA(), TagC.class));
	}

	@Test(expected = IllegalArgumentException.class)
	public void assertHasAncestorOfTypeWithNullTagName() throws Exception {
		TagUtils.assertHasAncestorOfType(new TagA(), TagC.class, null, "c");
	}

	@Test(expected = IllegalArgumentException.class)
	public void assertHasAncestorOfTypeWithNullAncestorTagName() throws Exception {
		TagUtils.assertHasAncestorOfType(new TagA(), TagC.class, "a", null);
	}

	@Test(expected = IllegalStateException.class)
	public void assertHasAncestorOfTypeThrowsExceptionOnFail() throws Exception {
				Tag a = new TagA();
				Tag b = new TagB();
				Tag anotherB = new TagB();

				a.setParent(b);
				b.setParent(anotherB);

				TagUtils.assertHasAncestorOfType(a, TagC.class, "a", "c");
	}

	@Test
	public void testAssertHasAncestorOfTypeDoesNotThrowExceptionOnPass() throws Exception {
		Tag a = new TagA();
		Tag b = new TagB();
		Tag c = new TagC();

		a.setParent(b);
		b.setParent(c);

		TagUtils.assertHasAncestorOfType(a, TagC.class, "a", "c");
	}

	@SuppressWarnings("serial")
	private static final class TagA extends TagSupport {

	}

	@SuppressWarnings("serial")
	private static final class TagB extends TagSupport {

	}

	@SuppressWarnings("serial")
	private static final class TagC extends TagSupport {

	}

}
