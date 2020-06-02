package com.java8.function;

import java.util.Objects;
import java.util.function.Function;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
@FunctionalInterface
public interface ThrowingFunction<T, R> extends Function<T, R> {

	@Override
	default R apply(T t) {
		try {
			return applyThrows(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	default <V> ThrowingFunction<T, V> andThen(ThrowingFunction<? super R, ? extends V> after) {
		Objects.requireNonNull(after);
		try {
			return (T t) -> after.apply(apply(t));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	default <V> ThrowingFunction<V, R> compose(ThrowingFunction<? super V, ? extends T> before) {
		Objects.requireNonNull(before);
		try {
			return (V v) -> apply(before.apply(v));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	R applyThrows(T t) throws Exception;

}