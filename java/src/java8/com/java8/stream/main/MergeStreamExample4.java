package com.java8.stream.main;

import java.util.stream.Stream;

/**
 * và nếu nhiều hơn nữa =)) thì code sẽ trở nên quá xấu. Tuy nhiên chúng ta có
 * thể dùng cách dưới đây để giải quyết.
 * 
 * Đầu tiên hãy tạo 1 Stream chứa 4(hoặc nhiều hơn) Stream con, kiểu dữ liệu nó
 * lưu trữ sẽ là Stream<Stream<Integer>>
 * 
 * Sau đó ta có thể dùng flatMap() để biến nó thành 1 Stream<Integer>
 * 
 * Ngoài các cách ở trên, bạn cũng có thể dùng các thư viện để thực hiện được
 * việc merge Stream:
 * 
 * StreamEx: là một thư viện mã nguồn mở của Java, nó extends Java 8 Streams và
 * cung cấp StreamEx class như một sự mở rộng cho Stream interface của JDK.
 * 
 * ... Stream<Integer> stream1 = Stream.of(1, 2, 3); Stream<Integer> stream2 =
 * Stream.of(4, 5, 6); Stream<Integer> stream3 = Stream.of(7, 8, 9, 10);
 * Stream<Integer> stream4 = Stream.of(77, 88, 99);
 * 
 * Stream<Integer> resultingStream = StreamEx.of(stream1) .append(stream2)
 * .append(stream3) .append(stream4); ...
 * 
 * jOOλ: cũng là 1 thư viện mở rộng cho JDK rất hữu dụng
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class MergeStreamExample4 {

	public static void main(String[] args) {
		Stream<Integer> stream1 = Stream.of(1, 2, 3);
		Stream<Integer> stream2 = Stream.of(4, 5, 6);
		Stream<Integer> stream3 = Stream.of(7, 8, 9, 10);
		Stream<Integer> stream4 = Stream.of(77, 88, 99);

		Stream<Integer> resultStream = Stream.of(stream1, stream2, stream3,
				stream4).flatMap(e -> e);

		resultStream.forEach(System.out::print);

//		Stream<Integer> resultingStream = StreamEx.of(stream1).append(stream2)
//				.append(stream3).append(stream4);
	}
}