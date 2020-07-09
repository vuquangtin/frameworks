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
public class UsingAnnWithValue {

	// Khởi tạo các phần tử của Annotation theo cách thông thường.
	@AnnWithValue(name = "Name1", value = 100)
	public void someMethod1() {

	}

	// Khởi tạo các phần tử của Annotation theo cách thông thường.
	// Phần tử 'name' của Annotation này sẽ có giá trị mặc định
	@AnnWithValue(value = 100)
	public void someMethod2() {

	}

	// Phần tử có tên 'value' là đặc biệt.
	// Thay vì viết @AnnWithValue(value = 100)
	// Bạn chỉ cần viết @AnnWithValue(100)
	@AnnWithValue(100)
	public void someMethod3() {

	}
}