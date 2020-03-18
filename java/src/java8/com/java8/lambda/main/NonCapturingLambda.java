package com.java8.lambda.main;

/**
 * <h1>Cách thức làm việc</h1>
 * <ul>
 * <li>
 * Như đã nói ở trên, trình biên dịch sẽ biên dịch Anonymous inner class thành
 * class file thông thường. -Ví dụ: AnonymousInnerClass$1.class,
 * AnonymousInnerClass$2.class,... Cũng như các class thông thường, Anonymous
 * inner class được load và verify khi start chương trình.</li>
 * <li>Lambda thì làm việc như sau:
 * 
 * </li>
 * <li>Lambdas được convert thành private static method của class chưa nó.</li>
 * <li>Method được gọi bởi method metafactory() của lớp LambdaMetafactory</li>
 * <li>Có hai loại Labdas là Non-capturing lambdas, và Capturing lambdas
 * Non-capturing lambdas Là Lambdas không truy cập các field ngoài phạm vi của
 * nó (blog code)</li>
 * </ul>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class NonCapturingLambda {
	public static void main(String[] args) {
		Runnable nonCapturingLambda = () -> System.out
				.println("NonCapturingLambda");
		nonCapturingLambda.run();
	}
}
