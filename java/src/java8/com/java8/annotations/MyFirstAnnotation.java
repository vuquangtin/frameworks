package com.java8.annotations;

/**
 * 
 Annotation có thể được gắn trên:
 * <ul>
 * <li>
 * TYPE - Gắn trên khai báo Class, interface, enum, annotation.</li>
 * <li>FIELD - Gắn trên khai báo trường (field), bao gồm cả các hằng số enum.</li>
 * <li>METHOD - Gắn trên khai báo method.</li>
 * <li>PARAMETER - Gắn trên khai báo parameter</li>
 * <li>CONSTRUCTOR - Gắn trên khai báo cấu tử</li>
 * <li>LOCAL_VARIABLE - Gắn trên biến địa phương.</li>
 * <li>ANNOTATION_TYPE - Gắn trên khai báo Annotation</li>
 * <li>PACKAGE - Gắn trên khai báo package.</li>
 * </ul>
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public @interface MyFirstAnnotation {

	// Phần tử 'name'.
	public String name();

	// Phần tử 'description', có giá trị mặc định "".
	public String description() default "";

}