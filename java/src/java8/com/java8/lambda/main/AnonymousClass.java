package com.java8.lambda.main;

/**
 * Anonymous inner class và Lambda trong Java có nhiều điểm tương đồng, nhưng
 * hiểu được những điểm khác nhau giữa chúng cũng rất quan trọng và hữu ích
 * trong công việc của lập trình viên. Bài viết này sẽ nêu ra một số điểm khác
 * nhau giữa Lambda và Anonymous inner class, và cách thức làm việc của chúng. <br/>
 * Anonymous inner class: Inner class là class (non static) được viết trong một
 * class khác (out-class). Anonymous class là Inner class nhưng không có
 * ''class' đặt trước tên của class. Ví dụ.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class AnonymousClass {
	public static void main(String args[]) {
		AnonymousInner inner = new AnonymousInner() {
			@Override
			public void myMethod() {
				System.out
						.println("This is an example of anonymous inner class");
			}
		};
		inner.myMethod();
	}
}

interface AnonymousInner {
	public void myMethod();
}
