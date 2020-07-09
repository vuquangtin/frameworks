package com.java8.annotations;

import java.util.Date;

/**
 * <h1>@Deprecated</h1>
 * 
 * Đây là một Annotation dùng để chú thích một cái gì đó bị lỗi thời, tốt nhất
 * không nên sử dụng nữa, chẳng hạn như class, hoặc method. Chú thích @Deprecated
 * được bộ biên dịch quan tâm để thông báo cho bạn nên dùng một cách nào đó thay
 * thế. Hoặc với các IDE lập trình chẳng hạn như Eclipse nó cũng sẽ có các thông
 * báo cho bạn một cách trực quan.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class DeprecatedMethodDemo {

	/**
	 * @deprecated replaced by {@link #todo(String,Date)}
	 */
	@Deprecated
	public void todoJob(String jobName) {
		System.out.println("Todo " + jobName);
	}

	public void todo(String jobName, Date atTime) {
		System.out.println("Todo " + jobName + " at " + atTime);
	}

	public void todoNothing() {
		System.out.println("Todo Nothing");
	}

	public static void main(String[] args) {

		DeprecatedMethodDemo obj = new DeprecatedMethodDemo();

		obj.todoJob("Java coding");

		obj.todoNothing();
	}
}