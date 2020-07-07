# What is PECS (Producer Extends Consumer Super)?

"PECS" is from the collection's point of view. If you are only pulling items from a generic collection, it is a producer and you should use extends; if you are only stuffing items in, it is a consumer and you should use super. If you do both with the same collection, you shouldn't use either extends or super.

Suppose you have a method that takes as its parameter a collection of things, but you want it to be more flexible than just accepting a Collection<Thing>.

## Case 1: You want to go through the collection and do things with each item.
Then the list is a producer, so you should use a Collection<? extends Thing>.

The reasoning is that a Collection<? extends Thing> could hold any subtype of Thing, and thus each element will behave as a Thing when you perform your operation. (You actually cannot add anything to a Collection<? extends Thing>, because you cannot know at runtime which specific subtype of Thing the collection holds.)

## Case 2: You want to add things to the collection.
Then the list is a consumer, so you should use a Collection<? super Thing>.

The reasoning here is that unlike Collection<? extends Thing>, Collection<? super Thing> can always hold a Thing no matter what the actual parameterized type is. Here you don't care what is already in the list as long as it will allow a Thing to be added; this is what ? super Thing guarantees.

# Difference between <? super T> and <? extends T> in Java

## extends

The wildcard declaration of List<? extends Number> foo3 means that any of these are legal assignments:
```java
List<? extends Number> foo3 = new ArrayList<Number>();  // Number "extends" Number (in this context)
List<? extends Number> foo3 = new ArrayList<Integer>(); // Integer extends Number
List<? extends Number> foo3 = new ArrayList<Double>();  // Double extends Number
```



1. Reading - Given the above possible assignments, what type of object are you guaranteed to read from List foo3:
 * You can read a Number because any of the lists that could be assigned to foo3 contain a Number or a subclass of Number.
 * You can't read an Integer because foo3 could be pointing at a List<Double>.
 * You can't read a Double because foo3 could be pointing at a List<Integer>.

2. Writing - Given the above possible assignments, what type of object could you add to List foo3 that would be legal for all the above possible ArrayList assignments:
 * You can't add an Integer because foo3 could be pointing at a List<Double>.
 * You can't add a Double because foo3 could be pointing at a List<Integer>.
 * You can't add a Number because foo3 could be pointing at a List<Integer>.

>You can't add any object to List<? extends T> because you can't guarantee what kind of List it is really pointing to, so you can't guarantee that the object is allowed in that List. The only "guarantee" is that you can only read from it and you'll get a T or subclass of T.

## super

Now consider List <? super T>.

The wildcard declaration of List<? super Integer> foo3 means that any of these are legal assignments:

```java
List<? super Integer> foo3 = new ArrayList<Integer>();  // Integer is a "superclass" of Integer (in this context)
List<? super Integer> foo3 = new ArrayList<Number>();   // Number is a superclass of Integer
List<? super Integer> foo3 = new ArrayList<Object>();   // Object is a superclass of Integer
```


1. Reading - Given the above possible assignments, what type of object are you guaranteed to receive when you read from List foo3:
 * You aren't guaranteed an Integer because foo3 could be pointing at a ```List<Number>``` or ```List<Object>```.
 * You aren't guaranteed a Number because foo3 could be pointing at a ```List<Object>```.
 * The only guarantee is that you will get an instance of an Object or subclass of Object(but you don't know what subclass).
2. Writing - Given the above possible assignments, what type of object could you add to List foo3 that would be legal for all the above possible ArrayList assignments:
 * You can add an Integer because an Integer is allowed in any of above lists.
 * You can add an instance of a subclass of Integer because an instance of a subclass of Integer is allowed in any of the above lists.
 * You can't add a Double because foo3 could be pointing at an ```ArrayList<Integer>```.
 * You can't add a Number because foo3 could be pointing at an ```ArrayList<Integer>```.
 * You can't add an Object because foo3 could be pointing at an ```ArrayList<Integer>```.


## PECS

Remember PECS: "Producer Extends, Consumer Super".

>"Producer Extends" - If you need a List to produce T values (you want to read Ts from the list), you need to declare it with ? extends T, e.g. List<? extends Integer>. But you cannot add to this list.


>"Consumer Super" - If you need a List to consume T values (you want to write Ts into the list), you need to declare it with ? super T, e.g. List<? super Integer>. But there are no guarantees what type of object you may read from this list.

If you need to both read from and write to a list, you need to declare it exactly with no wildcards, e.g. List<Integer>.

## Example

Note this example from the Java Generics FAQ. Note how the source list src (the producing list) uses extends, and the destination list dest (the consuming list) uses super:
```java
public class Collections { 
  public static <T> void copy(List<? super T> dest, List<? extends T> src) {
      for (int i = 0; i < src.size(); i++) 
        dest.set(i, src.get(i)); 
  } 
}
```


## Generic types are invariant

* That is, ```List<String>``` is not a subtype of ```List<Object>```
* Good for compile-time type safety, but inflexible

## Bounded wildcard types provide additional API flexibilty

* ```List<String>``` is a subtype of ```List<? extends Object>```
* ```List<Object>``` is a subtype of ```List<? super String>```

so

## PECS — Producer extends, Consumer super

* use ```Foo<? extends T>``` for a T producer
* use ```Foo<? super T>``` for a T consumer

only applies to input parameters (Don’t use wildcard types as return types).

Suppose you want to add bulk methods to Stack:

```java
void pushAll(Collection<? extends E> src);
//src is an E producer

void popAll(Collection<? super E> dst);
// dst is an E consumer
```
