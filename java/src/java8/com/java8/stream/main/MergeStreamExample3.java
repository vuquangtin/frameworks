package com.java8.stream.main;

import java.util.stream.Stream;

/**
 * Merging nhiều Streams
 * 
 * Ta có thể dễ dàng merge 2 Stream bằng cách sử dụng Stream.concat() như ví dụ
 * thêm 1 phần tử vào Stream ở trên. Nhưng trong trường hợp phải merge 3 Stream
 * thì sao? Code nhìn trông có vẻ loằng ngoằng hơn, như sau
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class MergeStreamExample3 {

	public static void main(String[] args) {
		Stream<Integer> stream1 = Stream.of(1, 2, 3);
		Stream<Integer> stream2 = Stream.of(4, 5, 6);
		Stream<Integer> stream3 = Stream.of(7, 8, 9, 10);

		Stream<Integer> resultStream = Stream.concat(
				Stream.concat(stream1, stream2), stream3);

		resultStream.forEach(System.out::print);
	}
}