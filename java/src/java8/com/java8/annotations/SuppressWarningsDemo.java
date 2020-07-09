package com.java8.annotations;

import java.util.Date;

/**
 * <h1>@SuppressWarnings</h1>
 * 
 * Chú thích @SuppressWarnings làm cho các trình biên dịch thôi không cảnh báo
 * một vấn đề của method nào đó. Ví dụ, nếu trong một method có gọi tới một
 * method khác đã lỗi thời, hoặc bên trong method có một ép kiểu không an toàn,
 * trình biên dịch có thể tạo ra một cảnh báo. Bạn có thể tắt các cảnh báo này
 * bằng cách chú thích method này bằng @SuppressWarnings. Hãy xem một ví dụ minh
 * họa:
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class SuppressWarningsDemo {

	@SuppressWarnings("deprecation")
	public Date getSomeDate() {

		Date date = new Date(2014, 9, 25);
		return date;
	}

}