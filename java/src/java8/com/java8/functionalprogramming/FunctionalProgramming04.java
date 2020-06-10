package com.java8.functionalprogramming;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

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
public class FunctionalProgramming04 extends TemplateMethod {
	public static void main(String[] args) {
		new FunctionalProgramming04().runTemplateMethod(args);
	}

	public static int totalAssetValues(final List<Asset> assets) {
		return totalAssetValues(assets, asset -> true);
	}

	public static int totalAssetValues(final List<Asset> assets, final Asset.AssetType type) {
		return totalAssetValues(assets, asset -> asset.type == type);
	}

	public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector) {
		int totalAssetValues = assets.stream().filter(assetSelector).mapToInt(asset -> asset.value).sum();
		return totalAssetValues;
	}

	@Test
	public void totalAssetValues() {
		final List<Asset> assets = Arrays.asList(new Asset(Asset.AssetType.BOND, 10),
				new Asset(Asset.AssetType.BOND, 20), new Asset(Asset.AssetType.STOCK, 30),
				new Asset(Asset.AssetType.STOCK, 40));
		int sum = totalAssetValues(assets);
		assertEquals(100, sum);

		int sumBonds = totalAssetValues(assets, Asset.AssetType.BOND);
		assertEquals(30, sumBonds);

		int sumStocks = totalAssetValues(assets, Asset.AssetType.STOCK);
		assertEquals(70, sumStocks);
	}

	@Test
	public void lambdasBaby() {
		final List<Asset> assets = new ArrayList<Asset>();
		for (int i = 0; i < 10; i++) {
			Asset asset = new Asset((i % 2 == 0) ? Asset.AssetType.STOCK : Asset.AssetType.BOND, i + 1);
			assets.add(asset);
		}
		int sumOfStockAssetsLessThanFive = totalAssetValues(assets,
				asset -> asset.type == Asset.AssetType.STOCK && asset.value < 5);
		assertEquals(4, sumOfStockAssetsLessThanFive);

		int sumOfEvenAssets = totalAssetValues(assets, asset -> asset.value % 2 == 0);
		assertEquals(30, sumOfEvenAssets);
	}

	@Test
	public void computeStockWorth() {
		// Note how easy it is, with lambdas, to "stub" out the priceFinder
		final CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal("6.01"));
		BigDecimal expected = new BigDecimal("6010.00");
		// I was unaware of the delta thing.
		assertEquals(0, calculateNAV.computeStockWorth("GOOG", 1000).compareTo(expected), 0.001);
	}

	static class YahooFinance {
		public static BigDecimal getPrice(final String ticker) {
			try {
				final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
				final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				final String data = reader.lines().skip(1).findFirst().get();
				final String[] dataItems = data.split(",");
				return new BigDecimal(dataItems[dataItems.length - 1]);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	@Test
	public void yahooFinanceIntegrationTest() {
		final CalculateNAV calculateNav = new CalculateNAV(YahooFinance::getPrice);
		BigDecimal oneGOOGShare = calculateNav.computeStockWorth("GOOG", 1);
		assertNotNull(oneGOOGShare);
		BigDecimal zero = new BigDecimal(0);
		assertTrue(oneGOOGShare.compareTo(zero) >= 0);

		// What if it changes between oneGOOGShare calc and now?
		BigDecimal expectedTenGOOGShares = oneGOOGShare.multiply(new BigDecimal(10));
		BigDecimal actualTenGOOGShares = calculateNav.computeStockWorth("GOOG", 10);
		assertEquals(expectedTenGOOGShares, actualTenGOOGShares);
	}

	private Function<Color, Color> filter;

	@SafeVarargs
	public final void setFilters(final Function<Color, Color>... filters) {
		filter = Stream.of(filters).reduce((filter, next) -> filter.compose(next)).orElse(color -> color);
	}

	public Color capture(final Color inputColor) {
		// More processing of color...
		final Color processedColor = filter.apply(inputColor);
		return processedColor;
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		setFilters();
		final Consumer<String> printCaptured = (filterInfo) -> System.out
				.println(String.format("with %s: %s", filterInfo, this.capture(new Color(200, 100, 200))));

		printCaptured.accept("no filter");

		this.setFilters(Color::brighter);
		printCaptured.accept("brighter filter");

		this.setFilters(Color::darker);
		printCaptured.accept("darker filter");

		this.setFilters(Color::brighter, Color::darker);
		printCaptured.accept("brighter & darker filter");

	}

	public interface Fly {
		default void takeOff() {
			System.out.println("Fly::takeOff");
		}

		default void land() {
			System.out.println("Fly::land");
		}

		default void turn() {
			System.out.println("Fly::turn");
		}

		default void cruise() {
			System.out.println("Fly::cruise");
		}
	}

	public interface FastFly extends Fly {
		default void takeOff() {
			System.out.println("FastFly::takeOff");
		}
	}

	public interface Sail {
		default void cruise() {
			System.out.println("Sail::cruise");
		}

		default void turn() {
			System.out.println("Sail::turn");
		}
	}

	public class Vehicle {
		public void turn() {
			System.out.println("Vehicle::turn");
		}
	}

	public class SeaPlane extends Vehicle implements FastFly, Sail {
		private int altitude;

		// ...
		public void cruise() {
			System.out.print("SeaPlane::cruise currently cruise like: ");
			if (altitude > 0) {
				FastFly.super.cruise();
			} else {
				Sail.super.cruise();
			}
		}
	}

	public void useClasses() {
		SeaPlane seaPlane = new SeaPlane();
		seaPlane.takeOff();
		seaPlane.turn();
		seaPlane.cruise();
		seaPlane.land();
	}

	/***
	 * DefaultMethods
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		this.useClasses();

	}

	public class MailBuilder {
		public MailBuilder from(final String address) {
			return this;
		}

		public MailBuilder to(final String address) {
			return this;
		}

		public MailBuilder subject(final String line) {
			return this;
		}

		public MailBuilder body(final String message) {
			return this;
		}

		public void send() {
			System.out.println("sending...");
		}

	}

	/***
	 * MailBuilder
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		MailBuilder mailer = new MailBuilder().from("build@agiledeveloper.com").to("venkats@agiledeveloper.com")
				.subject("build notification").body("...your code sucks...");
		mailer.send();
	}

	class Mailer {
		public void from(final String address) {
		}

		public void to(final String address) {
		}

		public void subject(final String line) {
		}

		public void body(final String message) {
		}

		public void send() {
			System.out.println("sending...");
		}

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		Mailer mailer = new Mailer();
		mailer.from("build@agiledeveloper.com");
		mailer.to("venkats@agiledeveloper.com");
		mailer.subject("build notification");
		mailer.body("...your code sucks...");
		mailer.send();

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

class Asset {
	public enum AssetType {
		BOND, STOCK
	};

	public final AssetType type;
	public final int value;

	public Asset(AssetType type, int value) {
		this.type = type;
		this.value = value;
	}
}

class CalculateNAV {
	private final Function<String, BigDecimal> priceFinder;

	public CalculateNAV(final Function<String, BigDecimal> aPriceFinder) {
		priceFinder = aPriceFinder;
	}

	public BigDecimal computeStockWorth(final String ticker, final int shares) {
		// Note that apply method is on Function
		return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
	}
}