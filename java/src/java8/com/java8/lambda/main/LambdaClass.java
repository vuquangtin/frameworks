package com.java8.lambda.main;

/**
 * 
 * Lambdas: Lambda Expressions là một trong những tính năng mới, quan trọng của
 * Java 8. Nó cung cấp cách thức rõ ràng và khúc triêt cách mô tả một method của
 * một interface bằng cách dùng biểu thức. Lambda Expression cũng cung cấp các
 * thư viện giúp cải tiến cách thưc làm việc với Collection như duyệt, filter,
 * và truy xuất dữ liệu.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class LambdaClass {
	public static void main(String[] args) {

		System.out.println("=== RunnableTest ===");

		// Anonymous Runnable
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");
		// Run em!
		r1.run();
		r2.run();

		Runnable r3 = () -> method();
		r3.run();
	}

	public static void method() {
		System.out.println("Hello world 3!");
	}
}
