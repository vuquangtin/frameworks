package com.java8.adv.reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.java8.adv.abs.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class ClassInternalInfo extends TemplateMethod {

	public static void main(String[] args) {
		new ClassInternalInfo().runTemplateMethod(args);

	}

	/***
	 * ConstructorGetTest
	 */
	@Override
	public void implementionOne(String[] args) {
		Class<Apple> appleClass = Apple.class;

		System.out.println("1, 演示 public Constructor<?>[] getConstructors()");
		System.out.println("获取所有的公共构造方法对象数组:");
		Constructor<?>[] constructors = appleClass.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}

		System.out.println("2, 演示 public Constructor<T> getConstructor(Class<?>... parameterTypes)");
		System.out.println("获取指定参数列表的公共构造方法对象");
		try {
			System.out.println("获取 public Apple():");
			Constructor<Apple> constructor = appleClass.getConstructor();
			System.out.println("constructor = " + constructor);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("获取 public Apple(String color, int size):");
			Constructor<Apple> constructor = appleClass.getConstructor(String.class, int.class);
			// 需要注意的是，下面这种写法会抛出异常：
			// java.lang.NoSuchMethodException:
			// com.java.advanced.features.reflect.Apple.<init>(java.lang.String,
			// java.lang.Integer)
			// 这是因为没有找到参数列表为(String, Integer) 的构造方法
			// Constructor<Apple> constructor1 =
			// appleClass.getConstructor(String.class, Integer.class);
			System.out.println("constructor = " + constructor);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("获取 private Apple(String color, Float price)：");
			appleClass.getConstructor(String.class, Float.class);
		} catch (NoSuchMethodException e) {
			System.out.println(e);
		}

		System.out.println("3, 演示 public Constructor<?>[] getDeclaredConstructors()");
		Constructor<?>[] declaredConstructors = appleClass.getDeclaredConstructors();
		System.out.println("获取所有的构造方法对象:");
		for (Constructor<?> declaredConstructor : declaredConstructors) {
			System.out.println(declaredConstructor);
		}

		System.out.println("4, 演示 public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)");
		System.out.println("获取指定参数列表的构造方法对象");
		try {
			System.out.println("获取 private Apple(String color, Float price)：");
			Constructor<Apple> constructor = appleClass.getDeclaredConstructor(String.class, Float.class);
			System.out.println("constructor = " + constructor);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("获取 public Apple()：");
			Constructor<Apple> constructor = appleClass.getDeclaredConstructor();
			System.out.println("constructor = " + constructor);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}

	/***
	 * ConstructorNewInstanceTest
	 */
	@Override
	public void implementionTwo(String[] args) {
		Class<Apple> appleClass = Apple.class;
		try {
			// 1，获取到 private Apple(String color, Float price) 对应的 Constructor 对象
			Constructor<Apple> declaredConstructor = appleClass.getDeclaredConstructor(String.class, Float.class);
			// 因为目标构造方法是 private 的，所以需要设置下边的代码为 true。
			declaredConstructor.setAccessible(true);
			// Apple apple = declaredConstructor.newInstance("red",
			// Float.valueOf(1.8f));
			// 上面一行等价于下面一行
			Apple apple = declaredConstructor.newInstance("red", 1.8f);
			// 错误写法演示1: 参数顺序写错，抛出：java.lang.IllegalArgumentException: argument
			// type mismatch
			// declaredConstructor.newInstance(Float.valueOf(1.8f), "red");
			// 错误写法演示2：参数个数写错，抛出: java.lang.IllegalArgumentException: wrong
			// number of arguments
			// declaredConstructor.newInstance("red");
			System.out.println(apple);
			System.out.println("color = " + apple.getColor() + ", price = " + apple.getPrice());
		} catch (NoSuchMethodException | IllegalAccessException | InstantiationException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		try {
			// 2, 获取 public Apple(String color, int size) 对应的 Constructor 对象
			Constructor<Apple> constructor = appleClass.getConstructor(String.class, int.class);
			Apple apple = constructor.newInstance("red", 100);
			// 上面一行等价于下面一行
			// Apple apple = constructor.newInstance("red",
			// Integer.valueOf(100));
			System.out.println(apple);
			System.out.println("color = " + apple.getColor() + ", size = " + apple.getSize());
		} catch (NoSuchMethodException | IllegalAccessException | InstantiationException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	/***
	 * FieldGetTest
	 */
	@Override
	public void implementionThree(String[] args) {
		Class<Apple> appleClass = Apple.class;

		System.out.println("1, 演示 public Field[] getDeclaredFields()");
		System.out.println("获取本类所有已声明字段的 Field 对象数组");
		Field[] declaredFields = appleClass.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			System.out.println(declaredField);
		}

		System.out.println("2, 演示 public Field getDeclaredField(String name)");
		System.out.println("获取本类指定字段名的 Field 对象");
		try {
			System.out.println("获取 private int size;");
			Field sizeField = appleClass.getDeclaredField("size");
			System.out.println("sizeField = " + sizeField);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("获取 public float price;");
			Field priceField = appleClass.getDeclaredField("price");
			System.out.println("priceField = " + priceField);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("获取父类 Fruit 的 public String taste;");
			appleClass.getDeclaredField("taste");
		} catch (NoSuchFieldException e) {
			// 此处抛出异常：java.lang.NoSuchFieldException: taste
			System.out.println(e);
		}

		System.out.println("3, 演示 public Field[] getFields()");
		System.out.println("获取所有已声明字段的公共Field 对象数组，包括继承自父类的");
		Field[] fields = appleClass.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}

		System.out.println("4, 演示 public Field getField(String name)");
		System.out.println("获取指定字段名的公共的 Field 对象");
		try {
			System.out.println("获取 private String size");
			;
			Field sizeField = appleClass.getField("size");
		} catch (NoSuchFieldException e) {
			System.out.println(e);
		}

		try {
			System.out.println("获取 public float price;");
			Field priceField = appleClass.getField("price");
			System.out.println(priceField);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

	}

	/***
	 * FieldSetGetTest1
	 */
	@Override
	public void implementionFour(String[] args) {
		try {
			Class<Apple> appleClass = Apple.class;
			Constructor<Apple> constructor = appleClass.getConstructor();
			Apple apple = constructor.newInstance();
			System.out.println("1, 获取 String color; 字段，修改它的值并获取修改后的值：");
			Field colorField = appleClass.getDeclaredField("color");
			// 解除此 Field 对象的 Java 语言访问控制
			colorField.setAccessible(true);
			colorField.set(apple, "red");
			String color = (String) colorField.get(apple);
			System.out.println("color = " + color + ", getColor() = " + apple.getColor());

			System.out.println("2, 获取 private int size; 字段，修改它的值并获取修改后的值：");
			Field sizeField = appleClass.getDeclaredField("size");
			// 下面这行不写，会报异常：
			// java.lang.IllegalAccessException: Class
			// com.java.advanced.features.reflect.
			// classinternalinfo.field.FieldApiTest can not access a member of
			// class
			// com.java.advanced.features.reflect.Apple with modifiers "private"
			sizeField.setAccessible(true);
			sizeField.set(apple, 10);
			int size = (int) sizeField.get(apple);
			System.out.println("size = " + size + ", getSize() = " + apple.getSize());

			System.out.println("3, 获取 private static int count; 字段，修改它的值并获取修改后的值：");
			Field countField = appleClass.getDeclaredField("count");
			countField.setAccessible(true);
			// 对于 set 来说， 如果底层字段是一个静态字段，则忽略 obj 变量；它可能为 null。
			// 所以，这里第一个参数 obj，可以为 null。当然，也可以填入对象值。
			countField.set(null, 33);
			// 对于 get 来说， 如果底层字段是一个静态字段，则忽略 obj 变量；它可能为 null。
			// 所以，这里第一个参数 obj，可以为 null。当然，也可以填入对象值。
			int count = (int) countField.get(null);
			System.out.println("count = " + count + ", getCount() = " + Apple.getCount());

			System.out.println("下面演示几种异常：");
			System.out.println("1: 实例字段下，指定对象变量为 null，抛出 NullPointerException 异常");
			try {
				Field priceField = appleClass.getField("price");
				priceField.set(null, 12f);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("2: 实例字段下，指定对象变量不是类的实例，抛出 IllegalArgumentException 异常");
			try {
				Field priceField = appleClass.getField("price");
				priceField.set(new Fruit(), 12f);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("3: 底层字段的类型是基本类型，但是设置给 obj 的字段的新值无法转换为基本类型，抛出 IllegalArgumentException");
			try {
				Field priceField = appleClass.getField("price");
				priceField.set(apple, "price");
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/***
	 * FieldSetGetTest2
	 */
	@Override
	public void implementionFive(String[] args) {
		try {
			Class<Apple> appleClass = Apple.class;
			Constructor<Apple> constructor = appleClass.getConstructor();
			Apple apple = constructor.newInstance();

			System.out.println("1, 获取 private int size; 字段，修改它的值并获取修改后的值：");
			Field sizeField = appleClass.getDeclaredField("size");
			sizeField.setAccessible(true);
			sizeField.setInt(apple, 10);
			int size = sizeField.getInt(apple);
			System.out.println("size = " + size + ", getSize() = " + apple.getSize());

			System.out.println("2, 获取 private static int count; 字段，修改它的值并获取修改后的值：");
			Field countField = appleClass.getDeclaredField("count");
			countField.setAccessible(true);
			// 对于 set 来说， 如果底层字段是一个静态字段，则忽略 obj 变量；它可能为 null。
			// 所以，这里第一个参数 obj，可以为 null。当然，也可以填入对象值。
			countField.setInt(null, 33);
			// 对于 get 来说， 如果底层字段是一个静态字段，则忽略 obj 变量；它可能为 null。
			// 所以，这里第一个参数 obj，可以为 null。当然，也可以填入对象值。
			int count = countField.getInt(null);
			System.out.println("count = " + count + ", getCount() = " + Apple.getCount());

			System.out.println("3, 获取 public float price; 字段，修改它的值并获取修改后的值：");
			Field priceField = appleClass.getField("price");
			priceField.setFloat(apple, 12f);
			float price = priceField.getFloat(apple);
			System.out.println("price = " + price + ", getPrice() = " + apple.getPrice());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/***
	 * MethodGetTest
	 */
	@Override
	public void implementionSix(String[] args) {
		Class<Apple> appleClass = Apple.class;
		System.out.println("1, 演示 public Method[] getDeclaredMethods()");
		System.out.println("获取本类声明的所有方法对象，但不包括继承的方法");
		Method[] declaredMethods = appleClass.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			System.out.println(declaredMethod);
		}

		System.out.println("2, 演示 public Method getDeclaredMethod(String name, Class<?>... parameterTypes)");
		try {
			System.out.println("获取 void checkSize(Integer size)");
			Method checkSizeMethod = appleClass.getDeclaredMethod("checkSize", Integer.class);
			// 下面的写法会抛出异常：java.lang.NoSuchMethodException:
			// com.java.advanced.features.reflect.Apple.checkSize(int)
			// Method checkSizeMethod =
			// appleClass.getDeclaredMethod("checkSize", int.class);
			System.out.println(checkSizeMethod);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("获取 private void checkPrice(float price)");
			Method checkPriceField = appleClass.getDeclaredMethod("checkPrice", float.class);
			// 下面的写法会抛出异常：java.lang.NoSuchMethodException:
			// com.java.advanced.features.reflect.Apple.checkPrice(java.lang.Float)
			// Method checkPriceField =
			// appleClass.getDeclaredMethod("checkPrice", Float.class);
			System.out.println(checkPriceField);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		System.out.println("3, 演示 public Method[] getMethods()");
		Method[] methods = appleClass.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		System.out.println("4, 演示 public Method getMethod(String name, Class<?>... parameterTypes)");
		try {
			System.out.println("获取 private void checkPrice(float price)");
			Method checkPriceField = appleClass.getMethod("checkPrice", float.class);
		} catch (NoSuchMethodException e) {
			System.out.println(e);
		}

		try {
			System.out.println("获取  public String getColor()");
			Method colorMethod = appleClass.getMethod("getColor");
			System.out.println(colorMethod);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}

	/***
	 * MethodInvokeTest
	 */
	@Override
	public void implementionSeven(String[] args) {
		try {
			// 获取 Apple 对象
			Class<Apple> appleClass = Apple.class;
			Apple apple = appleClass.newInstance();
			// 演示 public Object invoke(Object obj, Object... args)
			// 获取 public void initColorAndPrice(String color, float price)
			// 方法，并调用
			Method initColorAndPriceMethod = appleClass.getDeclaredMethod("initColorAndPrice", String.class,
					float.class);
			boolean result = (boolean) initColorAndPriceMethod.invoke(apple, "red", 18f);
			System.out.println(
					"getColor() = " + apple.getColor() + ", getPrice() = " + apple.getPrice() + ", result = " + result);

			// 获取 void setSize(int size) 方法，并调用
			Method checkSizeMethod = appleClass.getDeclaredMethod("setSize", int.class);
			// 解除此 Method 对象的 Java 语言访问控制
			checkSizeMethod.setAccessible(true);
			// 没有返回值时，返回 null
			Object invoke = checkSizeMethod.invoke(apple, 100);
			System.out.println("getSize() = " + apple.getSize() + ", result = " + invoke);

			// 获取 public static int getCount() 方法，并调用
			Method getCountMethod = appleClass.getMethod("getCount");
			// 底层方法是静态的，那么可以忽略指定的 obj 参数。该参数可以为 null。
			int count = (int) getCountMethod.invoke(null);
			System.out.println("count = " + count);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/***
	 * GetClassTest
	 */
	@Override
	public void implementionEight(String[] args) {
		// 1, 通过类对象获取
		Apple apple = new Apple();
		Class appleClass1 = apple.getClass();
		System.out.println("appleClass1 = " + appleClass1);
		// 2, 通过类的 class 对象获取
		Class appleClass2 = Apple.class;
		System.out.println("appleClass2 = " + appleClass2);
		// 3, 通过全类名获取
		Class appleClass3 = null;
		try {
			appleClass3 = Class.forName("com.java.advanced.features.reflect.Apple");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("appleClass3 = " + appleClass3);
		// 4, 通过 ClassLoader.loadClass()加载
		Class appleClass4 = null;
		try {
			appleClass4 = ClassInternalInfo.class.getClassLoader()
					.loadClass("com.java.advanced.features.reflect.Apple");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("appleClass4 = " + appleClass4);

		System.out.println(
				"result = " + (appleClass1 == appleClass2 && appleClass2 == appleClass3 && appleClass3 == appleClass4));

	}

	@Override
	public void implementionNine(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) {
		// TODO Auto-generated method stub

	}

}
