package com.java8.date.main;

/**
 * Lời khuyên: Không nên sử dụng SimpleFormatDate.

Kể từ java 8 trở đi có rất nhiều thư viện tăng cường cho việc sử lý date mà lại sử dụng thread-safe như DateTimeFormatter

Bạn cũng nên chánh việc sử dụng các class như Date và Calendar và thử sử dụng Java 8 Class DateTime như:

OffsetDateTime, ZonedDateTime, LocalDateTime, LocalDate, LocalTime

Cung cấp rất nhiều chức năng hiệu quả hơn so với Date và Calendar.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatThreadSafetyExample {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");

	public static void main(String[] args) {
		String dateStr = "2018-06-22T10:00:00";

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Runnable task = new Runnable() {
			@Override
			public void run() {
				parseDate(dateStr);
			}
		};

		for (int i = 0; i < 100; i++) {
			executorService.submit(task);
		}

		executorService.shutdown();
	}

	private synchronized static void parseDate(String dateStr) {
		try {
			Date date = simpleDateFormat.parse(dateStr);
			System.out.println("Successfully Parsed Date " + date);
		} catch (ParseException e) {
			System.out.println("ParseError " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}