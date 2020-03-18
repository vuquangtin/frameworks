package com.java8.methodreferences.main;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Method references
 * 
 * Nếu một lambda expression xử lý một phương thức như một object thì method
 * references xử lý một method như một lambda. Chúng ta sẽ xem xét ví dụ sau để
 * hiểu rõ hơn
 * 
 * Trong cú pháp method reference , double-colon được sử dụng để thể hiện
 * reference đến phương thức println của instance System.out.
 * 
 * Method reference có 2 ưu điểm so với lambda expression. Đầu tiên là ngắn gọn
 * và thứ hai là nó bao gồm tên của class bao gồm method đó. Cả hai điều này làm
 * cho code dễ đọc hơn.
 * 
 * Method referece cũng được sử dụng cho static method. Ví dụ Math.random như
 * sau
 * 
 * Tham số của static method generate là một Supplier, đây là một functional
 * interface bao gồm một phương thức trừu tượng không tham số và return về một
 * giá trị. Phương thức random của lớp Math phù hợp với chữ ký của SMA (nằm
 * trong Supplier) vì nó cũng là phương thức không tham số, và return về một giá
 * trị đơn. Nói cách khác, method reference Math::random được thể hiện như một
 * sự thực thi của Supplier interface.
 * 
 * Tiếp theo chúng ta sẽ tìm hiểu một số cách sử dụng method reference
 * 
 * object::instanceMethod -> ví dụ: System.out::println
 * 
 * Class::staticMethod -> ví dụ: Math::max
 * 
 * Class::instanceMethod -> ví dụ String::length
 * 
 * Chú ý cách sử dụng thứ 3 rất dễ gây nhầm lẫn với static method. Chúng ta cần
 * nhớ là cả lambda expression lẫn method reference không bao giờ tồn tại độc
 * lập mà nó phải được thể hiện trong một ngữ cảnh nào đó.
 * 
 * Cuối cùng, chúng ta sẽ xem một số ví dụ về cách chuyển đổi giữa lambda và
 * method reference sau
 * 
 * 
 * // equivalent to System.out::println
 * 
 * x -> System.out.println(x);
 * 
 * // equivalent to Math::max
 * 
 * (x,y) -> Math.max(x,y);
 * 
 * // equivalent to String::length
 * 
 * x -> x.length();
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Main {
	public static void main(String[] args) {
		Stream.of(3, 1, 4, 1, 5, 9).forEach(x -> System.out.println(x));
		// sử dụng lambda

		Stream.of(3, 1, 4, 1, 5, 9).forEach(System.out::println);
		// sử dụng method reference

		Consumer<Integer> printer = System.out::println;
		// gán method reference như một functional interface
		Stream.of(3, 1, 4, 1, 5, 9).forEach(printer);

		Stream.generate(Math::random).limit(10).forEach(System.out::println);

		Stream.of(3, 1, 4, 1, 5, 9).forEach(new Main()::print);
		Stream.of(3, 1, 4, 1, 5, 9).forEach(Main::staticPrint);

	}

	public void print(Object obj) {
		System.out.println(obj.toString());
	}

	public static void staticPrint(Object obj) {
		System.out.println(obj.toString());

	}
}