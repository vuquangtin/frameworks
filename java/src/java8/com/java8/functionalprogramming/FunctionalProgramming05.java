package com.java8.functionalprogramming;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
public class FunctionalProgramming05 extends TemplateMethod {

	public static void main(String[] args) {
		new FunctionalProgramming05().runTemplateMethod(args);

	}

	public void runLocked(Lock lock, Runnable block) {
		lock.lock();
		try {
			block.run();
		} finally {
			lock.unlock();
		}
	}

	Lock lock = new ReentrantLock(); // or mock

	protected void setLock(final Lock mock) {
		lock = mock;
	}

	public void doOp1() {
		lock.lock();
		try {
			// ...critical code...
		} finally {
			lock.unlock();
		}
	}

	public void doOp2() {
		runLocked(lock, () -> {
			/* ...critical code ... */
		});
	}

	public void doOp3() {
		runLocked(lock, () -> {
			/* ...critical code ... */
		});
	}

	public void doOp4() {
		runLocked(lock, () -> {
			/* ...critical code ... */
		});
	}

	class RodCutter {
		private boolean mustFail;

		public RodCutter(final boolean fail) {
			mustFail = fail;
		}

		public void setPrices(final List<Integer> prices) {
			// ...
			if (mustFail) {
				throw new RodCutterException();
			}
		}

		public int maxProfit(final int length) {
			if (length == 0) {
				throw new RodCutterException();
			}
			return 0;
		}

	}

	class RodCutterException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

	@FunctionalInterface
	public interface UseInstance<T, X extends Throwable> {
		void accept(T instance) throws X;
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
