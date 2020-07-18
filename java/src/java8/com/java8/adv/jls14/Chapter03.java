package com.java8.adv.jls14;

import com.java.frameworks.base.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Chapter03 extends TemplateMethod {

	public static void main(String[] args) {
		new Chapter03().runTemplateMethod(args);

	}

	class C {
		C() {
		}

		int b;

		int g(int i) {
			return i;
		}

	}

	class main extends C {
		int b;

		int g(int i) {
			return i;
		}

		C a = new C();

		C f(int i) {
			return a;
		}

		main(String[] args) {
			Object lo;
			int li;
			// situatii posibile:

			// 'This()
			lo = this;

			// 'ExprName(b)
			li = b;

			// 'Invoke('Method('MethodName(g)),,_)
			li = g(2);

			// 'Field('This(),,b)
			li = this.b;

			// 'Invoke('Method('This(),,_,,g),,_)
			li = this.g(2);

			// 'SuperField(b)
			li = super.b;

			// 'Invoke('SuperMethod(_,,g),,_)
			li = super.g(2);

			// 'ExprName('AmbName(a),,b)
			li = a.b;

			// 'Invoke('Method('MethodName('AmbName(a),,g)),,_)
			li = a.g(2);

			// 'Field('Invoke('Method('MethodName(f)),,_),,b)
			li = f(1).b;

			// 'Invoke(
			// 'Method(
			// 'Invoke('Method('MethodName(f)),,_),,
			// _,,
			// g
			// ),,
			// _
			// )
			li = f(1).g(2);

			logger.debug("Done!");
		}
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		new main(args);

	}

	class D {
		int b;

		int g(int i) {
			return i;
		}

		D a;

		D f(int i) {
			return this;
		}

		void init() {
			a = this;
		}
	}

	class mainD extends D {
		int b;

		int g(int i) {
			return i;
		}

		D f(int i) {
			return a;
		}

		D field;
		D a;

		void main(String[] args) {
			super.init();

			Object lo;
			int li;

			new D().init();
			field = a = this;
			D local = this;

			li = this.a.b;
			li = this.a.g(3);
			li = this.f(2).b;
			li = this.f(2).g(3);

			li = super.a.b;
			li = super.a.g(3);
			li = super.f(2).b;
			li = super.f(2).g(3);

			li = field.a.b;
			li = field.a.g(3);
			li = field.f(2).b;
			li = field.f(2).g(3);

			li = local.a.b;
			li = local.a.g(3);
			li = local.f(2).b;
			li = local.f(2).g(3);

			li = f(1).a.b;
			li = f(1).a.g(3);
			li = f(1).f(2).b;
			li = f(1).f(2).g(3);

			logger.debug("Done!");
		}
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		new mainD().main(args);

	}

	class E {
		int b;

		int g(int i) {
			return i;
		}

		E a;

		E f(int i) {
			return this;
		}

		void init() {
			a = this;
		}
	}

	class mainE extends E {
		int b;

		int g(int i) {
			return i;
		}

		E f(int i) {
			return a;
		}

		E field;
		E a;

		void main(String[] args) {
			super.init();

			new E().init();
			field = a = this;
			E local = this;

			this.b = 1;
			super.b = 2;
			field.b = 3;
			local.b = 4;
			f(1).b = 5;

			this.a.b = 1;
			this.f(1).b = 1;
			super.a.b = 2;
			super.f(1).b = 2;
			field.a.b = 3;
			field.f(1).b = 3;
			local.a.b = 4;
			local.f(1).b = 4;
			f(1).a.b = 5;
			f(1).f(1).b = 5;

			logger.debug("Done!");
		}
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		new mainE().main(args);

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		int li;
		boolean lb;

		int a = 0, i = 1;

		// Infix operators
		lb = true || false;
		// lb = true && false;
		// li = 1 | 2;
		// li = 1 ^ 2;
		// li = 1 & 2;
		lb = 1 == 2;
		lb = 1 != 2;
		lb = 1 < 2;
		lb = 1 > 2;
		lb = 1 <= 2;
		lb = 1 >= 2;
		// li = 1 << 2;
		// li = 1 >> 2;
		// li = 1 >>> 2;
		li = 1 + 2;
		li = 1 - 2;
		li = 1 * 2;
		li = 1 / 2;
		li = 1 % 2;

		// Prefix operators
		// ++ i;
		// -- i;
		lb = !true;
		// li = ~ 1;
		li = +1;
		li = -1;

		// Postfix operators
		i++;
		i--;

		// Ternary operator
		li = 4 > 2 ? 4 : 2;

		// Assignment operators
		a = i;
		// a += i;
		// a -= i;
		// a *= i;
		// a /= i;
		// a %= i;
		// a &= i;
		// a |= i;
		// a ^= i;
		// a <<= i;
		// a >>= i;
		// a >>>= i;

		logger.debug("Done!");

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		int li;
		boolean lb;

		int a = 0, i = 1;

		// Infix operators
		// lb = true || false;
		lb = true && false;
		li = 1 | 2;
		li = 1 ^ 2;
		li = 1 & 2;
		// lb = 1 == 2;
		// lb = 1 != 2;
		// lb = 1 < 2;
		// lb = 1 > 2;
		// lb = 1 <= 2;
		// lb = 1 >= 2;
		li = 1 << 2;
		li = 1 >> 2;
		li = 1 >>> 2;
		// li = 1 + 2;
		// li = 1 - 2;
		// li = 1 * 2;
		// li = 1 / 2;
		// li = 1 % 2;

		// Prefix operators
		++i;
		--i;
		// lb = ! true;
		li = ~1;
		// li = + 1;
		// li = - 1;

		// Postfix operators
		// i ++;
		// i --;

		// Ternary operator
		// li = 4 > 2 ? 4 : 2;

		// Assignment operators
		// a = i;
		a += i;
		a -= i;
		a *= i;
		a /= i;
		a %= i;
		a &= i;
		a |= i;
		a ^= i;
		a <<= i;
		a >>= i;
		a >>>= i;

		logger.debug("Done!");

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

}
