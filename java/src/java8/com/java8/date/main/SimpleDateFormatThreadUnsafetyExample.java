package com.java8.date.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Gần đây mình có đọc một bài viết về issue của SimpleDateFormat trong ứng dụng Multiple thread của java.

Đầu tiên SimpleDateFormat là thư viện sử dụng format( pattern dạng chuỗi) và parse dates trong Java

Bạn có thể tạo một instance của classs SimpleDateFormat với một pattern như yyyy-MM-dd HH:mm:ss và sử dụng instence đấy để format và parse date từ một String.

Một trong các điều quan trọng nhất cần lưu ý về SimpleDateFormat là class này không sử dụng thread safe và nó có thể gây ra một số vấn đề khi sử dụng trong môi trường multi-thread

Và sau đây tôi xin trình đi thẳng vào vấn đề:
Ví dụ SimpleDateFormat trong môi trường đa luồng

Để bạn hiểu về issue tôi sẽ tạo SimpleDateFormat trong môi trường multi-threaded mà không có bất kỳ phép đồng bộ nào.

Dưới đây là một ví dụ rất cơ bản. Tôi sẽ chuyển một string thành date từ theo một pattern định nghĩa trước nhưng tôi sẽ làm nó trong môi trường đa luồng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */

public class SimpleDateFormatThreadUnsafetyExample {

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

	private static void parseDate(String dateStr) {
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
