package com.java8.function;

import java.util.function.Supplier;

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
public interface ThrowingSupplier<U> extends Supplier<U> {

    @Override
    default U get() {
        try {
            return getThrows();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    U getThrows() throws Exception;
}