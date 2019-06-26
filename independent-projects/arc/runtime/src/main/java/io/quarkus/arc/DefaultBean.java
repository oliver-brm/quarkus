package io.quarkus.arc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * If a producer method is annotated with this, it means that the bean it produces will only be used
 * as a default bean if no other bean of this type is configured. If other another bean is configured
 * however, the default bean is not used.
 *
 * Here is an example:
 *
 * <pre>
 * &#64;Dependent
 * public class SomeConfiguration {
 *
 *     &#64;Produces
 *     &#64;DefaultBean
 *     public MyBean create() {
 *         // create bean
 *     }
 * }
 * </pre>
 *
 * If this code is used MyBean is not defined anywhere else, then the result of create() is used in all injection points.
 *
 * If however there is another piece of configuration code that looks like:
 *
 * <pre>
 * &#64;Dependent
 * public class SomeOtherConfiguration {
 *
 *     &#64;Produces
 *     public MyBean override() {
 *         // create bean
 *     }
 * }
 * </pre>
 *
 * Then the result of override will be used as a MyBean in all injection points
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DefaultBean {

}
