package com.java8.adv.basic;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
abstract class SuperAbstract {
	public void nonAbstract() {
		// some code
	}

	public abstract void contract();
}

abstract class SubAbstract extends SuperAbstract {
	public void additionalNonAbstract() {
		// some code
	}
	@Override
	public void contract() {
		// some code
	}
	public abstract void additionalContract();
}

class Concrete extends SubAbstract {
	public void contract() {
		// implementation
	}

	public void additionalContract() {
		// implementation
	}
}

// although below is allowed and sometimes when we use an external library then
// this is one of the way but still this is not a good practice.
// dependencies should be on abstractions only and not on concrete
// implementation
abstract class AnotherAbstract extends Concrete {
	public void someMethod() {
		// some code
	}

	public abstract void oneMoreContract();
}
class ConcreteB extends SubAbstract {
	public void additionalContract() {
		// some implementation
	}
}
public class ConcreteA extends AnotherAbstract {
	public void oneMoreContract() {
		// some implementation
	}
}