package com.java8.stream.main;

import java.util.stream.Stream;

/**
 * Làm thế nào để merge stream trong java 8
 * 
 * Các bạn nếu đã làm việc với Java 8 thì hẳn đã quen thuộc với Stream. Tuy
 * nhiên liệu các bạn đã từng tự hỏi làm sao để merge các Stream lại? Trong bài
 * viết này chúng ta sẽ cùng tìm hiểu xem làm sao có thể thêm được 1 phần tử vào
 * Stream và làm thế nào để merge các Stream 😃 Đầu tiên hãy cùng xem xét làm
 * sao thêm được 1 phần tử đơn vào Stream?
 * 
 * Chúng ta có thể dễ dàng thêm một phần tử đã cho vào một Stream bằng cách gọi
 * phương thức Stream.concat():
 * 
 * Trong ví dụ dưới, 1 phần tử được thêm vào đầu của 1 Stream cho sẵn.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class MergeStreamExample {

	public static void main(String[] args) {
		Stream<Integer> firstStream = Stream.of(11, 22, 33, 44, 55);

		Stream<Integer> secondStream = Stream
				.concat(Stream.of(99), firstStream);

		secondStream.forEach(System.out::println);
	}

	/**
	 * Tương tự như vậy, để thêm một phần tử vào cuối Stream, chúng ta chỉ cần
	 * đảo ngược các đối số.
	 * 
	 * @param args
	 */
	public static void main2(String[] args) {
		Stream<Integer> firstStream = Stream.of(11, 22, 33, 44, 55);

		Stream<Integer> secondStream = Stream
				.concat(firstStream, Stream.of(99));

		secondStream.forEach(System.out::println);
	}
}