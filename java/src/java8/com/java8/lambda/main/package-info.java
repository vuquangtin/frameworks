/*Những điểm khác nhau

    Lambdas chỉ thực thi Functional Interface
    Anonymous inner class có thẻ extends class, impliments interface với số lượng method bất kỳ.

    Lambdas chỉ truy cập biến final hay effectively final.
    Anonymous inner class thì có thể truy cập biến final và biến thông thường.

    Khi biên dịch, Lambdas được biên dịch thành lệnh invokedynamic
    Anonymous inner class được biên dịch thành class thông thường.
    
    Functional Interfaces

Runnable trong Java là một functional interfaces, nó chỉ có một method là Run(). ActionListener interface cũng vậy.

package java.awt.event;
import java.util.EventListener;

public interface ActionListener extends EventListener {
   public void actionPerformed(ActionEvent e);

}

Thông thường ta đặt các listenner cho component như sau.

button.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
   System.out.println("hello");
  }
 });

Với lambda expressions sẽ trở nên đơn giản hơn nhiều.
Lambda Expressions (LamExp)

button.addActionListener(e -> System.out.println("hello"));

    
    Cấu trúc của lambda expressions
Agument list 	Arrow tocken 	Body
([Data type] [param1], [param2], [param_n]) 	-> 	{body};

    LamExp có thể không có, có một, hoặc nhiều tham số. () -> "Framgia"; (a) -> return a\*a; (int a, int b) -> return a\*b
    Tham số của có thể được định nghĩa kiểu một cách tường minh hoặc không cần định nghĩa kiểu. Kiểu sẽ được suy ra từ ngữ cảnh cụ thể.
    Các tham số được đặc trong hai dấu đóng mở đơn (params), khi chỉ có một tham số thì có thể không cần đặt trong dấu đóng mở. a -> return a\*a
    Body code của LamExp được đặt trong dấu đóng mở nhọn {body}, khi body code chỉ có một sử lý (thể hiện) thì không cần có dấu đóng mở nhọn.

LamExp qua ví dụ cụ thể

Thread

Cách thông thường khởi tạo và run một thread.

Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
       System.out.println("I am a thread.");
    }
  }).start();

Sử dụng LamExp.

Thread thread = new Thread(
   () -> {System.out.println("I am a thread.");}).start();

Duyệt collection

Cách thông thường khởi tạo và run một thread.

//Khai báo và khởi tạo list các phần tử Integer.
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//Duyệt và in ra console từng phần tử của danh sách.
for(Integer n: list) {
	System.out.println(n);
}

Sử dụng LamExp.

List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
list.forEach(n -> System.out.println(n););

Một ví dụ phức tạp hơn là ta sử dụng interface Predicate để in các phần tử trong danh sách trên theo những tiêu chí khác nhau.
*/
package com.java8.lambda.main;