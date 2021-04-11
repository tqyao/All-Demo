/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解定义
 * 注解的参数类似无参数方法，可以用default设定一个默认值（强烈推荐）。最常用的参数应当命名为value。
 * 【@Target】 元注解：有一些注解可以修饰其他注解，这些注解就称为元注解（meta annotation）。
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/4/11 22:44 <br>
 */
@Target({
        ElementType.METHOD,
        ElementType.FIELD,
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
