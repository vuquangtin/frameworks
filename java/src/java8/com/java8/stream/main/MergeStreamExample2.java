package com.java8.stream.main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Vậy để thêm 1 phần tử vào Stream theo index thì ta phải làm thế nào?
 * 
 * Hoạt động này không được Stream API hỗ trợ đầy đủ bởi vì về cơ bản Stream
 * không phải là tập hợp và không quan tâm đến khái niệm index.
 * 
 * Tuy nhiên trong thực tế nhiều khi phát sinh những việc như phải chèn phần tử
 * mới vào Stream, trước khi thực hiện các thao tác khác với Stream. Vì vậy, để
 * thực hiện việc này, chúng ta cần chuyển đổi Stream thành List, sau đó chèn
 * phần tử và cuối cùng, nhận Stream từ List mới đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */

public class MergeStreamExample2 {

	public static void main(String[] args) {
		Stream<Integer> firstStream = Stream.of(11, 22, 33, 44, 55);

		Stream<Integer> secondStream = insertIntoStream(firstStream, 99, 2);

		secondStream.forEach(System.out::println);
	}

	public static <T> Stream<T> insertIntoStream(Stream<T> stream, T element,
			int index) {
		List<T> result = stream.collect(Collectors.toList());
		result.add(index, element);
		return result.stream();
	}
}