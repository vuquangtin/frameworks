package com.java8.annotations;

/**
 * <h1>@Override</h1>
 * 
 * Annotation @Override được sử dụng cho các method ghi đè của method trong một
 * class cha (superclass). Nếu method này không hợp lệ với một method trong
 * class cha, trình biên dịch sẽ thông báo cho bạn một lỗi.
 * 
 * Annotation @Override là không bắt buộc phải chú thích trên method đã ghi đè
 * method của class cha. Đó là một ý tưởng tốt để sử dụng nó. Trong trường hợp
 * một người nào đó thay đổi tên của method của class cha, method tại class của
 * bạn sẽ không còn là method ghi đè nữa. Nếu không có chú thích @Override bạn
 * sẽ không tìm ra. Với các chú thích @Override trình biên dịch sẽ cho bạn biết
 * rằng các phương pháp trong các lớp con không ghi đè bất kỳ phương thức trong
 * lớp cha. Hãy xem ví dụ minh họa:
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class OverrideDemo extends Job {

	// Đây là một phương thức ghi đè phương thức getName() của lớp cha.
	// @Override không bắt buộc phải gắn trên phương thức này.
	// Nhưng nó cần thiết nếu ai đó thay đổi tên của phương thức getName()
	// của class cha, sẽ có một thông báo lỗi cho bạn biết.
	@Override
	public String getName() {
		return "Java Coding";
	}

}