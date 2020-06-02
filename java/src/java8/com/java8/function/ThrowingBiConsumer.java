package com.java8.function;

import java.util.Objects;
import java.util.function.BiConsumer;

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
public interface ThrowingBiConsumer<T, U> extends BiConsumer<T, U> {

    @Override
    default void accept(T t, U u) {
        try {
            acceptThrows(t,u);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    default  ThrowingBiConsumer<T, U> andThen(ThrowingBiConsumer<? super T, ? super U> after){
        Objects.requireNonNull(after, "BiConsumer can't be null");
        return (l, r) -> {
            accept(l, r);
            after.accept(l, r);
        };

    }

    void acceptThrows(T t, U u) throws Exception;

}