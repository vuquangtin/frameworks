package com.java8.adv.reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java8.adv.reflect.ReflectsTest;
import com.java8.adv.reflector.Reflect.BatchReflect;
import com.java8.adv.reflector.Reflect.ClassReflect;
import com.java8.adv.reflector.Reflect.ConstructorReflect;
import com.java8.adv.reflector.Reflect.FieldReflect;
import com.java8.adv.reflector.Reflect.MethodReflect;
import com.java8.adv.reflector.Reflect.ObjectReflect;

/**
 * 
 * https://github.com/y1j2x34/reflect/blob/
 * f4a7272e7d47f26b1757be91fd31d2b9b98daa53/README.md
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectTest {

	public static void main(String[] args) throws Throwable {
		// 包装类
		ClassReflect cr = Reflect.on(Person.class);
		ClassReflect cr1 = Reflect.on(ReflectsTest.packageName + ".Person");
		ClassReflect cr2 = Reflect.on(ReflectsTest.packageName + ".Person",
				ClassLoader.getSystemClassLoader());// 指定类加载器
		// 包装对象
		ObjectReflect or = Reflect.on(new Person());
		// 包装字段
		Field f = Person.class.getDeclaredField("name");
		FieldReflect fr = Reflect.on(f);
		FieldReflect fr1 = Reflect.on(f, new Person("mario"));// 绑定字段默认作用对象
		// 包装方法
		Method m = Person.class.getDeclaredMethod("say", String.class);
		MethodReflect mr = Reflect.on(m);
		MethodReflect mr2 = Reflect.on(m, new Person());// 绑定方法默认作用对象
		MethodReflect mr3 = Reflect.on(m, new Person(),
				new Object[] { "hello world" });// 绑定方法默认作用对象和参数
		// 包装构造器
		Constructor<?> constr = Person.class.getDeclaredConstructor(
				String.class, int.class);
		ConstructorReflect cr3 = Reflect.on(constr);
		ConstructorReflect cr4 = Reflect.on(constr, "john", 26);// 绑定默认构造参数
		// off() 获取被包装的对象
		// cr.off() == constr; //==> true

		Reflect.on(Person.class).create();// Reflect.on(new Person());
		Reflect.on(Person.class).create("mario");// Reflect.on(new
													// Person("mario"));
		Reflect.on(Person.class).create("kankan", 26);// Reflect.on(new
														// Person("kankan",26));

		Reflect op = Reflect.on(Person.class).create();
		// 精确查找
		op.method("say", String.class);
		op.method("selfIntroduction");
		// 根据提供的参数类型查找
		op.method("say", "你好");

		Reflect op1 = Reflect.on(Person.class).create("data");
		// 所有字段
		Map<String, FieldReflect> allFields = op1.fields(1);
		// 某个字段
		FieldReflect nameField = op1.field("name");
		// 字段值
		try {
			op1.field("name").get().off();// returns "data"
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			// 所有字段值
			Map<String, Reflect> values = op1.fieldValues();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Reflect.on(Person.class).create().method("say", String.class)
				.call((Object) "你好世界");// output: 你好世界

		Method sayMethod = Person.class.getDeclaredMethod("say", String.class);
		MethodReflect methodBindArgs = Reflect.on(sayMethod,
				new Object[] { "讲中文" });
		methodBindArgs.callBy(new Person());// output : 讲中文。

		MethodReflect mr4 = Reflect.on(sayMethod);
		mr4.bind("讲鸟语").callBy(new Person("小明"));// output: 小明说：讲鸟语
		try {
			Reflect.on(Person.class).method("say", "讲鸟语")
					.callBy(new Person("小明"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 50; i++) {
			persons.add(new Person("Person " + i));
		}
		BatchReflect reflect = Reflect.on(persons.toArray());
		for (Reflect r : reflect.call("getName")) {
			System.out.println(r.off());
		}
		// output:
		// "Person 1"
		// "Person 2"
		// "Person 3"
		// ...

		Sex s1 = Reflect.onEnum(Sex.class).add("ALIEN", "无");
		Sex s2 = Reflect.onEnum(Sex.class).add("OTHER");
		System.out.println(s1.name());
		System.out.println(s2.name());
		Sex alien = Sex.valueOf("ALIEN");
		Sex other = Sex.valueOf("OTHER");
		System.out.println(alien.name());
		System.out.println(other.name());
	}
}