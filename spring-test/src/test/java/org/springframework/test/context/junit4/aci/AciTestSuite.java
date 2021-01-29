

package org.springframework.test.context.junit4.aci;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.test.context.junit4.aci.annotation.InitializerWithoutConfigFilesOrClassesTests;
import org.springframework.test.context.junit4.aci.annotation.MergedInitializersAnnotationConfigTests;
import org.springframework.test.context.junit4.aci.annotation.MultipleInitializersAnnotationConfigTests;
import org.springframework.test.context.junit4.aci.annotation.OrderedInitializersAnnotationConfigTests;
import org.springframework.test.context.junit4.aci.annotation.OverriddenInitializersAnnotationConfigTests;
import org.springframework.test.context.junit4.aci.annotation.SingleInitializerAnnotationConfigTests;
import org.springframework.test.context.junit4.aci.xml.MultipleInitializersXmlConfigTests;

/**
 * Convenience test suite for integration tests that verify support for
 * {@link ApplicationContextInitializer ApplicationContextInitializers} (ACIs)
 * in the TestContext framework.
 *
 * @author Sam Brannen
 * @since 3.2
 */
@RunWith(Suite.class)
// Note: the following 'multi-line' layout is for enhanced code readability.
@SuiteClasses({//
	MultipleInitializersXmlConfigTests.class,//
	SingleInitializerAnnotationConfigTests.class,//
	MultipleInitializersAnnotationConfigTests.class,//
	MergedInitializersAnnotationConfigTests.class,//
	OverriddenInitializersAnnotationConfigTests.class,//
	OrderedInitializersAnnotationConfigTests.class,//
	InitializerWithoutConfigFilesOrClassesTests.class //
})
public class AciTestSuite {
}
