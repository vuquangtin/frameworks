package com.java8.lambda.main;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class LambdaChain {
	public String chainInt = "";
	public static long chainLong = 100;
	public static Integer chainInteger;
	public static Double chain;

	public static void main(String[] args) {
		// ChainConcrete c = (m) -> new Concrete();
		ChainInit m = s -> (v,l) -> i -> d -> (ch) -> new Concrete(s, l, i, d, ch);
		Concrete concrete = m.get("1000").chain("kkkk",10l).chain(100).chain(1000d).chain(new Character('a'));
		System.out.println(concrete.toString());
		//ChainString chm=s->{};

	}

	public interface ChainInit {
		public ChainString get(String chainString);
	}

	public interface ChainString {
		public ChainInteger chain(String chainString,long chainLong);
	}

	public interface ChainInteger {
		public ChainObject chain(Integer chainInteger);
	}

	public interface ChainObject {
		public ChainConcrete chain(Double chain);
	}

	public interface ChainConcrete {
		public Concrete chain(Character m);
	}

	public static class Concrete {
		String str;
		long chainLong;
		Integer chainInteger;
		Double chain;
		Character m;

		public Concrete(String str, long chainLong, Integer chainInteger, Double chain, Character m) {
			this.str = str;
			this.chainLong = chainLong;
			this.chainInteger = chainInteger;
			this.chain = chain;
			this.m = m;
		}

		@Override
		public String toString() {
			return str + "" + chainLong + chainInteger + chain + m;
		}
	}
}
