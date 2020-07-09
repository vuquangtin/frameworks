package com.java8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
@Retention(RetentionPolicy.RUNTIME)
// Annotation này nói rằng:
// AnnHtmlUL chỉ được sử dụng cho Class, interface, annotation, enum.
@Target(value = { ElementType.TYPE })
// AnnHtmlUL: Mô phỏng thẻ (tag) <UL> trong HTML.
public @interface AnnHtmlUL {

	public String border() default "border:1px solid blue;";

}