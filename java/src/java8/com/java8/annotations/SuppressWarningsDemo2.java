package com.java8.annotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class SuppressWarningsDemo2 {

	public List<?> getDatas() {
		List<String> list = new ArrayList<String>();
		list.add("One");
		return list;
	}

	@SuppressWarnings({ "deprecation", "unused", "unchecked" })
	public void processDatas() {

		// Bạn đang sử dụng constructor lỗi thời
		// Và biến 'date' đã được tạo ra, nhưng không được sử dụng.
		Date date = new Date(2014, 9, 25);

		// Ép kiểu (cast) không an toàn.
		// Và biến 'datas' được tạo ra, nhưng không được sử dụng trong code.
		List<String> datas = (List<String>) this.getDatas();
	}

}