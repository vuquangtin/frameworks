package com.java8.adv.exceptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
public class ExceptionsWithLambda extends TemplateMethod {

	public static void main(String[] args) {
		new ExceptionsWithLambda().runTemplateMethod(args);

	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20);
		integers.forEach(i -> System.out.println(50 / i));

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(i -> {
			try {
				System.out.println(50 / i);
			} catch (ArithmeticException e) {
				e.printStackTrace();
				System.err.println("Arithmetic Exception occured : "
						+ e.getMessage());
			}
		});
	}

	static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
		return i -> {
			try {
				consumer.accept(i);
			} catch (ArithmeticException e) {
				System.err.println("Arithmetic Exception occured : "
						+ e.getMessage());
			}
		};
	}

	/***
	 * The use of try-catch solves the problem, but the conciseness of a Lambda
	 * Expression is lost and it's no longer a small function as it's supposed
	 * to be.
	 * 
	 * To deal with this problem, we can write a lambda wrapper for the lambda
	 * function. Let's look at the code to see how it works:
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(lambdaWrapper(i -> System.out.println(50 / i)));

	}

	/***
	 * At first, we wrote a wrapper method that will be responsible for handling
	 * the exception and then passed the lambda expression as a parameter to
	 * this method.
	 * 
	 * The wrapper method works as expected but, you may argue that it's
	 * basically removing the try-catch block from lambda expression and moving
	 * it to another method and it doesn't reduce the actual number of lines of
	 * code being written.
	 * 
	 * This is true in this case where the wrapper is specific to a particular
	 * use case but we can make use of generics to improve this method and use
	 * it for a variety of other scenarios:
	 * 
	 * @param consumer
	 * @param clazz
	 * @return
	 */
	static <T, E extends Exception> Consumer<T> consumerWrapper(
			Consumer<T> consumer, Class<E> clazz) {

		return i -> {
			try {
				consumer.accept(i);
			} catch (Exception ex) {
				try {
					E exCast = clazz.cast(ex);
					System.err.println("Exception occured : "
							+ exCast.getMessage());
				} catch (ClassCastException ccEx) {
					throw ex;
				}
			}
		};
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(consumerWrapper(i -> System.out.println(50 / i),
				ArithmeticException.class));

	}

	/***
	 * Handling Checked Exceptions
	 * 
	 * Let's modify the example from the previous section and instead of
	 * printing to the console, let's write to a file.
	 * 
	 * @param integer
	 * @throws IOException
	 */
	static void writeToFile(Integer integer) throws IOException {
		// logic to write to file which throws IOException
	}

	/***
	 * Note that the above method may throw the IOException.
	 * 
	 * On compilation, we get the error:
	 * 
	 * java.lang.Error: Unresolved compilation problem: Unhandled exception type
	 * IOException
	 * 
	 * Let's see what happens when we declare the IOException on the main
	 * method:
	 * 
	 * public static void main(String[] args) throws IOException { List<Integer>
	 * integers = Arrays.asList(3, 9, 7, 0, 10, 20); integers.forEach(i ->
	 * writeToFile(i)); }
	 * 
	 * Still, we get the same error of unhandled IOException during the
	 * compilation.
	 * 
	 * java.lang.Error: Unresolved compilation problem: Unhandled exception type
	 * IOException
	 * 
	 * This is because lambda expressions are similar to Anonymous Inner
	 * Classes.
	 * 
	 * 
	 */
	@Override
	public void implementionFive(String[] args) throws Exception, IOException {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		try {
			integers.forEach(i -> {
				// This is because lambda expressions are similar to Anonymous
				// Inner Classes.
				// try {
				writeToFile(i);
				// } catch (Exception e) {
				// e.printStackTrace();
				// }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/***
	 * As we can see accept method doesn't declare any checked exception. This
	 * is why writeToFile isn't allowed to throw the IOException.
	 * 
	 * The most straightforward way would be to use a try-catch block, wrap the
	 * checked exception into an unchecked exception and rethrow it:
	 */
	@Override
	public void implementionSix(String[] args) throws Exception {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(i -> {
			try {
				writeToFile(i);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});

	}

	/***
	 * This gets the code to compile and run. However, this approach introduces
	 * the same issue we already discussed in the previous section – it's
	 * verbose and cumbersome.
	 * 
	 * We can get better than that.
	 * 
	 * Let's create a custom functional interface with a single accept method
	 * that throws an exception.
	 * 
	 * @author vuquangtin
	 *
	 * @param <T>
	 * @param <E>
	 */
	@FunctionalInterface
	public interface ThrowingConsumer<T, E extends Exception> {
		void accept(T t) throws E;
	}

	/***
	 * And now, let's implement a wrapper method that's able to rethrow the
	 * exception:
	 * 
	 * @param throwingConsumer
	 * @return
	 */
	static <T> Consumer<T> throwingConsumerWrapper(
			ThrowingConsumer<T, Exception> throwingConsumer) {

		return i -> {
			try {
				throwingConsumer.accept(i);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}

	/***
	 * Finally, we're able to simplify the way we use the writeToFile method:
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(throwingConsumerWrapper(i -> writeToFile(i)));
		/*
		 * This is still a kind of a workaround, but the end result looks pretty
		 * clean and is definitely easier to maintain.
		 * 
		 * Both, the ThrowingConsumer and the throwingConsumerWrapper are
		 * generic and can be easily reused in different places of our
		 * application.
		 */

	}

	/***
	 * 
	 * Handling a Checked Exception in Lambda Expression
	 * 
	 * In this final section, we'll modify the wrapper to handle checked
	 * exceptions.
	 * 
	 * Since our ThrowingConsumer interface uses generics, we can easily handle
	 * any specific exception.
	 * 
	 * @param throwingConsumer
	 * @param exceptionClass
	 * @return
	 */

	static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(
			ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {

		return i -> {
			try {
				throwingConsumer.accept(i);
			} catch (Exception ex) {
				try {
					E exCast = exceptionClass.cast(ex);
					System.err.println("Exception occured : "
							+ exCast.getMessage());
				} catch (ClassCastException ccEx) {
					throw new RuntimeException(ex);
				}
			}
		};
	}

	/***
	 * Let's see how to use it in practice:
	 */
	@Override
	public void implementionEight(String[] args) throws Exception {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		integers.forEach(handlingConsumerWrapper(i -> writeToFile(i),
				IOException.class));
		/*
		 * Note, that the above code handles only IOException, whereas any other
		 * kind of exception is rethrown as a RuntimeException.
		 */
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
