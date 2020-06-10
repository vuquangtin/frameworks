package com.java8.functionalprogramming;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.frameworks.base.TemplateMethod;
import com.java8.functionalprogramming.FunctionalProgramming04.YahooFinance;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class FunctionalProgramming08 extends TemplateMethod {

	public static void main(String[] args) {
		new FunctionalProgramming08().runTemplateMethod(args);

	}

	static class Tickers {
		public static final List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL",
				"ADBE", "AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");
	}

	static class StockInfo {
		public final String ticker;
		public final BigDecimal price;

		public StockInfo(final String symbol, final BigDecimal thePrice) {
			ticker = symbol;
			price = thePrice;
		}

		public String toString() {
			return String.format("ticker: %s price: %g", ticker, price);
		}
	}

	static class StockUtil {
		public static StockInfo getPrice(final String ticker) {
			return new StockInfo(ticker, YahooFinance.getPrice(ticker));
		}

		public static Predicate<StockInfo> isPriceLessThan(final int price) {
			return stockInfo -> stockInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;
		}

		public static StockInfo pickHigh(final StockInfo stock1, final StockInfo stock2) {
			return stock1.price.compareTo(stock2.price) > 0 ? stock1 : stock2;
		}
	}

	public static void findHighPriced(final Stream<String> symbols, String label) {
		long start = System.currentTimeMillis();
		final StockInfo highPriced = symbols.map(StockUtil::getPrice).filter(StockUtil.isPriceLessThan(500))
				.reduce(StockUtil::pickHigh).get();
		System.out.println("High priced under $500 is " + highPriced);
		System.out.println("Elapsed: " + (System.currentTimeMillis() - start) + "ms PickStockFunctional " + label);
	}

	/***
	 * PickStockFunctional
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		findHighPriced(Tickers.symbols.stream(), "stream");
		findHighPriced(Tickers.symbols.parallelStream(), "parallelStream");

	}

	/***
	 * Stocks100
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		final BigDecimal HUNDRED = new BigDecimal("100");
		System.out.println("Stocks priced over $100 are "
				+ Tickers.symbols.stream().filter(symbol -> YahooFinance.getPrice(symbol).compareTo(HUNDRED) > 0)
						.sorted().collect(Collectors.joining(", ")));

	}

	private static final List<StockInfo> stocks = new ArrayList<>();

	@Override
	public void implementionThree(String[] args) throws Exception {
		final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan(500);
		StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);

		System.out.println("---------------------------Long imperative style-----------------------------------");
		longImperative(isPriceLessThan500, highPriced);

		System.out
				.println("\n" + "---------------------------Short imperative style----------------------------------");
		shortImperative(isPriceLessThan500, highPriced);

		System.out
				.println("\n" + "---------------------------Functional style----------------------------------------");
		functional(Tickers.symbols.stream());

	}

	private static void longImperative(Predicate<StockInfo> isPriceLessThan500, StockInfo highPriced) {
		final List<StockInfo> stocksPriceUnder500 = new ArrayList<>();
		for (String symbol : Tickers.symbols) {
			stocks.add(StockUtil.getPrice(symbol));
		}
		for (StockInfo stock : stocks) {
			if (isPriceLessThan500.test(stock))
				stocksPriceUnder500.add(stock);
		}
		for (StockInfo stock : stocksPriceUnder500) {
			highPriced = StockUtil.pickHigh(highPriced, stock);
		}
		System.out.println("High priced under $500 is " + highPriced);

	}

	private static void shortImperative(Predicate<StockInfo> isPriceLessThan500, StockInfo highPriced) {
		for (String symbol : Tickers.symbols) {
			StockInfo stockInfo = StockUtil.getPrice(symbol);
			if (isPriceLessThan500.test(stockInfo))
				highPriced = StockUtil.pickHigh(highPriced, stockInfo);
		}
		System.out.println("High priced under $500 is " + highPriced);
	}

	private static void functional(final Stream<String> symbols) {
		final StockInfo highPriced = symbols.map(StockUtil::getPrice).filter(StockUtil.isPriceLessThan(500))
				.reduce(StockUtil::pickHigh).get();

		System.out.println("High priced under $500 is " + highPriced);
	}
	/*
	 * CLOSURES: A closure is the combination of a function bundled together
	 * (enclosed) with references to its surrounding state (the lexical
	 * environment). In other words, a closure gives you access to an outer
	 * function’s scope from an inner function. Closures are commonly used to
	 * give objects data privacy. When you use closures for data privacy, the
	 * enclosed variables are only in scope within the containing (outer)
	 * function. You can’t get to the data from an outside scope except through
	 * the object’s privileged methods. In JavaScript, any exposed method
	 * defined within the closure scope is privileged. Closures are also used
	 * when we need to partially apply functions and also for currying. The
	 * returned partial function is the privileged function that remembers the
	 * applied parameters. Closures are basically stateful functions
	 */

	@FunctionalInterface // optional
	public interface NumToTextConverter {
		String convert(int x);
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		NumToTextConverter textOfWeekday = new NumToTextConverter() {
			String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

			@Override
			public String convert(int num) {
				return (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
			};
		};
		System.out.println(textOfWeekday.convert(1)); // Mon

	}

	// Type 3: Closure with predefined Functional Interface, with Lambda
	// expression
	@Override
	public void implementionFive(String[] args) throws Exception {
		Function<Integer, String> getTextOfWeekday = num -> {
			String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
			return (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
		};
		System.out.println(getTextOfWeekday.apply(3)); // Wed

	}

	// Type 2: Closure with custom Functional Interface & Lambda expression
	@Override
	public void implementionSix(String[] args) throws Exception {
		NumToTextConverter textOfWeekday = num -> {
			String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
			return (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
		};
		System.out.println(textOfWeekday.convert(2)); // Tue

	}

	// Type 4: Closure with predefined Functional Interface, with Lambda
	// expression,
	// with inner function having access to parent scope (String [] weeks)
	static Function<Integer, String> getTextOfWeekday() {
		String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

		// privileged inner function that encloses/remembers weeks
		return num -> (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		System.out.println(getTextOfWeekday().apply(4)); // Thu
	}

	// Type 5: Closure with predefined Functional Interface, with Lambda
	// expression,
	// with inner function having access to parent scope
	// parent scope, in this scope, is nothing but state passed by client
	static Function<Integer, String> getTextOfWeekday(String[] weeks) {
		return num -> (num > 0 && num <= weeks.length) ? weeks[num - 1] : null;
	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		Function<Integer, String> getArabTextOfWeekday = getTextOfWeekday(
				new String[] { "Fri", "Sat", "Sun", "Mon", "Tue", "Wed", "Thu" });
		Function<Integer, String> getIndianTextOfWeekday = getTextOfWeekday(
				new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" });
		System.out.println(getArabTextOfWeekday.apply(5)); // Tue
		System.out.println(getIndianTextOfWeekday.apply(5)); // Fri

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
