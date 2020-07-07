package com.java8.adv.jls14;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
enum OperationT {
	PLUS {
		double eval(double x, double y) {
			return x + y;
		}

		@Override
		double eval(double x, double y, double z) {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	MINUS {
		double eval(double x, double y) {
			return x - y;
		}

		@Override
		double eval(double x, double y, double z) {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	TIMES {
		double eval(double x, double y) {
			return x * y;
		}

		@Override
		double eval(double x, double y, double z) {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	DIVIDED_BY {
		double eval(double x, double y) {
			return x / y;
		}

		@Override
		double eval(double x, double y, double z) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	// Each constant supports an arithmetic operation
	abstract double eval(double x, double y);

	abstract double eval(double x, double y, double z);

	public static void main(String args[]) {
		double x = Double.parseDouble("100");
		double y = Double.parseDouble("300");
		for (OperationT op : OperationT.values())
			System.out.println(x + " " + op + " " + y + " = " + op.eval(x, y));
	}
}
