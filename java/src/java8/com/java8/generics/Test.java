package com.java8.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
// NOTE CE - Compilation Error
// 4 - For

class A {
}

class B extends A {
}

class Animal {
}

public class Test {

	public static void main(String args[]) {

		A aObj = new A();
		B bObj = new B();

		// We can add object of same type (A) or its subType is legal
		List<A> list_A = new ArrayList<A>();
		list_A.add(aObj);
		list_A.add(bObj); // A aObj = new B(); //Valid
		// list_A.add(new String()); Compilation error (CE);
		// can't add other type A aObj != new String();

		// We can add object of same type (B) or its subType is legal
		List<B> list_B = new ArrayList<B>();
		// list_B.add(aObj); CE; can't add super type obj to subclass reference
		// Above is wrong similar like B bObj = new A(); which is wrong
		list_B.add(bObj);

		// Wild card (?) must only come for the reference (left side)
		// Both the below are wrong;
		// List<? super A> wildCard_Wrongly_Used = new ArrayList<? super A>();
		// List<? extends A> wildCard_Wrongly_Used = new ArrayList<? extends
		// A>();

		// Both <? extends A>; and <? super A> reference will accept = new
		// ArrayList<A>
		List<? super A> list_4__A_AND_SuperClass_A = new ArrayList<A>();
		list_4__A_AND_SuperClass_A = new ArrayList<Object>();
		// list_4_A_AND_SuperClass_A = new ArrayList<B>(); CE B is SubClass of A
		// list_4_A_AND_SuperClass_A = new ArrayList<String>(); CE String is not
		// super of A
		List<? extends A> list_4__A_AND_SubClass_A = new ArrayList<A>();
		list_4__A_AND_SubClass_A = new ArrayList<B>();
		// list_4__A_AND_SubClass_A = new ArrayList<Object>(); CE Object is
		// SuperClass of A

		// CE; super reference, only accepts list of A or its super classes.
		// List<? super A> list_4__A_AND_SuperClass_A = new ArrayList<String>();

		// CE; extends reference, only accepts list of A or its sub classes.
		// List<? extends A> list_4__A_AND_SubClass_A = new ArrayList<Object>();

		// With super keyword we can use the same reference to add objects
		// Any sub class object can be assigned to super class reference (A)
		list_4__A_AND_SuperClass_A.add(aObj);
		list_4__A_AND_SuperClass_A.add(bObj); // A aObj = new B();
		// list_4__A_AND_SuperClass_A.add(new Object()); // A aObj != new
		// Object();
		// list_4__A_AND_SuperClass_A.add(new String()); CE can't add other type

		// We can't put anything into "? extends" structure.
		// list_4__A_AND_SubClass_A.add(aObj); compilation error
		// list_4__A_AND_SubClass_A.add(bObj); compilation error
		// list_4__A_AND_SubClass_A.add(""); compilation error

		// The Reason is below
		// List<Apple> apples = new ArrayList<Apple>();
		// List<? extends Fruit> fruits = apples;
		// fruits.add(new Strawberry()); THIS IS WORNG :)

		// Use the ? extends wildcard if you need to retrieve object from a data
		// structure.
		// Use the ? super wildcard if you need to put objects in a data
		// structure.
		// If you need to do both things, don't use any wildcard.

		// Another Solution
		// We need a strong reference(without wild card) to add objects
		list_A = (ArrayList<A>) list_4__A_AND_SubClass_A;
		list_A.add(aObj);
		list_A.add(bObj);

		list_B = (List<B>) list_4__A_AND_SubClass_A;
		// list_B.add(aObj); compilation error
		list_B.add(bObj);

	}

	private Map<Class<? extends Animal>, List<? extends Animal>> animalListMap;

	public void registerAnimal(Class<? extends Animal> animalClass,
			Animal animalObject) {

		if (animalListMap.containsKey(animalClass)) {
			// Append to the existing List
			/*
			 * The ? extends Animal is a wildcard bounded by the Animal class.
			 * So animalListMap.get(animalObject); could return a List<Donkey>,
			 * List<Mouse>, List<Pikachu>, assuming Donkey, Mouse, and Pikachu
			 * were all sub classes of Animal. However, with the wildcard, you
			 * are telling the compiler that you don't care what the actual type
			 * is as long as it is a sub type of Animal.
			 */
			// List<? extends Animal> animalList =
			// animalListMap.get(animalObject);
			// animalList.add(animalObject); //Compilation Error because of
			// List<? extends Animal>
			List<Animal> animalList = animalListMap.get(animalObject);
			animalList.add(animalObject);

		}
	}
}