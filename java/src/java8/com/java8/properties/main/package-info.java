/**
 * 
Thông thường, properties file trong Java được sử dụng để lưu trữ dữ liệu cấu hình dự án hoặc các thông số cài đặt một cách rất hiệu quả. Có thể thấy trong các framework java thông dụng thì file properties được sử dụng khá phổ biến. Qua bài viết này, chúng ta sẽ cùng tìm hiểu về cách đọc và ghi dữ liệu vào properties file.
Properties

Properties là các giá trị cấu hình được quản lý như các cặp key/value pairs. Trong mỗi cặp key/value đều là các giá trị kiểu String. Key được dùng để xác định, và được sử dụng để lấy ra giá trị. Ví dụ: ứng dụng có khả năng tải tệp có thể sử dụng thuộc tính có tên "download.lastDirectory" để theo dõi thư mục được sử dụng cho lần tải cuối cùng.

Java cung cấp lớp java.util.Properties để quản lý các properties. Lớp này cung cấp một số các phương thức như sau:

    Tải các cặp key/value vào một đối tượng Properties
    Lấy ra một giá trị dựa vào key
    Liệt kê các key và giá trị của từng key,
    Lưu các properties vào một stream.
    ...

Lớp Properties kế thừa từ lớp java.util.Hashtable. Vì vậy nó có một số phương thức được kế thừa từ Hashtable như sau:

    Thử nghiệm để xem một khóa hoặc giá trị cụ thể có trong đối tượng Properties
    Loại bỏ một chìa khóa và giá trị của nó
    thêm một cặp khóa / giá trị vào danh sách thuộc tính
    liệt kê các giá trị hoặc các key
    lấy ra một giá trị bằng khóa của nó
    Tìm ra nếu đối tượng Properties trống
    ...

    Các cân nhắc về bảo mật: Quyền truy cập vào properties phải được sự chấp thuận của security manager hiện tại. Các đoạn code ví dụ trong phần này được giả định là thuộc các ứng dụng độc lập(standalone applications), mà theo mặc định, không có security manager.

 *
 */
package com.java8.properties.main;