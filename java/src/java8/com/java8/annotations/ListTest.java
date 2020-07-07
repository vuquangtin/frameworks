package com.java8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ListTest {
	@Target({ ElementType.FIELD, ElementType.CONSTRUCTOR,
			ElementType.LOCAL_VARIABLE })
	public @interface Tar {

	}

	public static void main(String[] args) {
		@SuppressWarnings({ "rawtypes", "unused" })
		@Tar
		List list = new ArrayList<String>();

		MySuperClass m = new MyClass();
		System.out.println(m.overrideMethod());
	}

	@Deprecated
	private int getAge() {
		return 100;
	}

	public static <T> boolean addAll(Collection<? super T> c, T... elements) {
		return false;
	}
}
