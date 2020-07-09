package com.java8.annotations;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
@MyFirstAnnotation(name = "Some name", description = "Some description")
public class UsingMyFirstAnnotation {

	// Annotation được gắn trên một Constructor.
	// Với giá trị của phần tử name là "John"
	// Giá trị phần tử description là "Write by John".
	@MyFirstAnnotation(name = "John", description = "Write by John")
	public UsingMyFirstAnnotation() {

	}

	// Annotation được gắn trên một phương thức.
	// Với giá trị của phần tử 'name' là "Tom"
	// Phần tử 'description' không được khai báo, nó sẽ lấy theo mặc định.
	@MyFirstAnnotation(name = "Tom")
	public void someMethod() {

	}

	// Annotation gắn trên tham số của một phương thức.
	public void todo(@MyFirstAnnotation(name = "none") String job) {

		// Annotation được gắn lên biến địa phương.
		@MyFirstAnnotation(name = "Some name")
		int localVariable = 0;

	}

}