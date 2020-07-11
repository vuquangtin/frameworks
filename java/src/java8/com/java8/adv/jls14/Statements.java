package com.java8.adv.jls14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class Statements extends TemplateMethod {

	public static void main(String[] args) {
		new Statements().runTemplateMethod(args);

	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		int m = 10;
		int t = 19;
		if (m > 0)
			if (t > 0)
				logger.debug("T>0");
			else
				logger.debug("AAA");

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		;
		;
		;
		;

	}

	class TestString {
		char[] value;
		int offset, count;

		int indexOf(TestString str, int fromIndex) {
			char[] v1 = value, v2 = str.value;
			int max = offset + (count - str.count);
			int start = offset + ((fromIndex < 0) ? 0 : fromIndex);
			i: for (int i = start; i <= max; i++) {
				int n = str.count, j = i, k = str.offset;
				while (n-- != 0) {
					if (v1[j++] != v2[k++])
						continue i;
				}
				return i - offset;
			}
			return -1;
		}
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		// (System.out.println("Hello world"));// illegal

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// (void)Integer.parseInt("121312");
		// incorrect!
		// Void v=(Void)Integer.parseInt("121312");
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		assert true;

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		List list = new ArrayList<Integer>();
		assert list != null && list.size() > 0 : "list variable is null or empty";
		Object value = list.get(0);

	}

	public enum Days {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

		public Days getAfterTomorroy(Days day) {
			switch (day) {
			case MONDAY:
				day = WEDNESDAY;
				break;
			case TUESDAY:
				day = THURSDAY;
				break;
			case WEDNESDAY:
				day = FRIDAY;
				break;
			case THURSDAY:
				day = SATURDAY;
				break;
			case FRIDAY:
				day = SUNDAY;
				break;
			case SATURDAY:
				day = MONDAY;
				break;
			case SUNDAY:
				day = TUESDAY;
				break;
			default:
				break;
			}
			return day;
		}

		public Days getBeforeYesterday(Days day) {
			switch (day) {
			case MONDAY: {
				int m = 100;
				logger.info("m=" + m);
				day = SATURDAY;
				if (m > 0)
					break;

			}
				break;
			case TUESDAY:
				day = SUNDAY;
				break;
			case WEDNESDAY:
				day = MONDAY;
				break;
			case THURSDAY:
				day = TUESDAY;
				break;
			case FRIDAY:
				day = WEDNESDAY;
				break;
			case SATURDAY:
				day = THURSDAY;
				break;
			case SUNDAY:
				day = FRIDAY;
				break;
			default:
				break;
			}
			return day;
		}
	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		logger.debug(Days.FRIDAY.getAfterTomorroy(Days.MONDAY));

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		int n = new Random().nextInt(1000);
		int q = (n + 7) / 8;
		// switch (n%8) {
		// case 0:
		// do { foo();
		// // Great C hack, Tom,
		// case 7:
		// foo();
		// // but it's not valid here.
		// case 6:
		// foo();
		// case 5:
		// foo();
		// case 4:
		// foo();
		// case 3:
		// foo();
		// case 2:
		// foo();
		// case 1:
		// foo();
		// } while (--q > 0);
		// }
	}

	static void howManyAgain(int k) {
		// java >8
		// switch (k) {
		// case 1 -> System.out.println("one");
		// case 2 -> System.out.println("two");
		// case 3 -> System.out.println("many");
		// }
	}

	private void foo() {
		// TODO Auto-generated method stub

	}

	public static String toHexString(int i) {
		StringBuffer buf = new StringBuffer(8);
		do {
			buf.append(Character.forDigit(i & 0xF, 16));
			i >>>= 4;
		} while (i != 0);
		return buf.reverse().toString();
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
