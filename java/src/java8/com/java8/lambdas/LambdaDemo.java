package com.java8.lambdas;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.java.frameworks.base.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */

public class LambdaDemo extends TemplateMethod {

	public static void main(String[] args) {
		new LambdaDemo().runTemplateMethod(args);
	}

	/**
	 * Old Thread...
	 */
	class HelloRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("Hello by HelloRunnable!");
		}
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		System.out.println("Welcome to lambda...");

		Runnable noArguments = () -> System.out.println("Hello world!");
		noArguments.run();

		HelloRunnable helloRunnable = new HelloRunnable();
		helloRunnable.run();

		Predicate<Integer> atLeastFive = x -> x > 5;

		int count = Stream.of(1, 2, 3, 4).reduce(0,
				(acc, element) -> acc + element);
		System.out.println(count);

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {

		UserNameService userNameService = new UserNameService() {
			@Override
			public void printName() {
				System.out.println("使用匿名类实现打印姓名！！！");
			}
		};
		userNameService.printName();

		UserNameService userNameServicePlus = () -> {
			System.out.println("使用Lambda表达式实现打印姓名！！！");
		};
		userNameServicePlus.printName();

		UserNameService userNameServicePlus1 = () -> System.out
				.println("使用Lambda表达式[省略大括号]实现打印姓名！！！");
		userNameServicePlus1.printName();

	}

	public void allLambdaForms() {

		Runnable noArguments = () -> System.out.println("实现了Runnable接口的Run函数");

		Thread thread = new Thread(noArguments);
		thread.start();

		Runnable multiStatement = () -> {
			System.out.print("打印1");
			System.out.println(" 打印2");
		};

		BinaryOperator<Long> add = (x, y) -> x + y;

		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

		Predicate<Integer> predicate = (x) -> x == 2;
		predicate.test(2);
	}

	public void setLambdaValue() {
		String name = "唐信国";
		name = "唐信滋";
		// Runnable noArguments = () ->
		// System.out.println("实现了Runnable接口的Run函数：姓名"+ name);

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		BinaryOperator<Long> addFunction = (x, y) -> x + y;
		System.out.println(addFunction.apply(100L, 100L));

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		BinaryOperator<Long> addFunction = (Long x, Long y) -> x + y;
		System.out.println(addFunction.apply(100L, 100L));

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		Runnable noArguments = () -> {
			System.out.println("Start a new thread!");
			System.out.println("Invoke the method logic!");
			System.out.println("Stop an existed thread!");
		};
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(noArguments);

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> {
			Random r = new Random();
			return r.nextInt();
		});
		System.out.println(threadLocal.get());
	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

}
