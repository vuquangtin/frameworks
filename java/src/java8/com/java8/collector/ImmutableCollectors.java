package com.java8.collector;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class ImmutableCollectors {

	public static <E> ImmutableListCollector<E> ofList() {
		return new ImmutableListCollector<>();
	}

	public static <E> ImmutableSetCollector<E> ofSet() {
		return new ImmutableSetCollector<>();
	}

	public static <E extends Comparable<?>> ImmutableSortedSetCollector<E> ofSortedSet() {
		return new ImmutableSortedSetCollector<>();
	}

	private static class ImmutableSetCollector<T> extends ImmutableCollector {
		@Override
		public Supplier<ImmutableSet.Builder<T>> supplier() {
			return ImmutableSet::builder;
		}

		@Override
		public Set<Characteristics> characteristics() {
			return Sets.newHashSet(Characteristics.CONCURRENT, Characteristics.UNORDERED);
		}
	}

	private static class ImmutableSortedSetCollector<T extends Comparable<?>> extends ImmutableCollector {
		@Override
		public Supplier<ImmutableSortedSet.Builder<T>> supplier() {
			return ImmutableSortedSet::naturalOrder;
		}
	}

	private static class ImmutableListCollector<T> extends ImmutableCollector {
		@Override
		public Supplier<ImmutableList.Builder<T>> supplier() {
			return ImmutableList::builder;
		}

	}

	@SuppressWarnings("unchecked")
	private static abstract class ImmutableCollector<T, A extends ImmutableCollection.Builder, R extends ImmutableCollection<T>>
			implements Collector {

		@Override
		public BiConsumer<A, T> accumulator() {
			return (c, v) -> c.add(v);
		}

		@Override
		public BinaryOperator<A> combiner() {
			return (c1, c2) -> (A) c1.addAll(c2.build().iterator());
		}

		@Override
		public Function<A, R> finisher() {
			return (bl -> (R) bl.build());
		}

		@Override
		public Set<Characteristics> characteristics() {
			return Sets.newHashSet(Characteristics.CONCURRENT);
		}
	}

}