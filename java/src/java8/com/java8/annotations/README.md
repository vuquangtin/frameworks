# Annotation Trong Java Là Gì Và Chức Năng Của Nó?

Trong quá trình học lập trình Java cơ bản, chúng ta có thể bắt gặp các ký hiệu như @Override, @Deprecated, @SuppressWarnings,...Vậy chúng là gì trong Java và chức năng của nó là gì? Cùng mình tìm hiểu trong bài viết "Tìm hiểu về Annotation trong Java" này nhé.

Trong bài viết này, mình chia sẻ về Annotation trong Java qua các nội dung sau:

1. Annotation trong Java là gì?
2. Cấu trúc của một Annotation trong Java.
3. Chức năng của Annotation trong Java.
4. Các Annotation tích hợp sẵn trong Java.
5. Khởi tạo Annotation (Annotation tự định nghĩa).
6. Annotation lồng nhau và cách sử dụng.


## 1. Annotation trong Java là gì?

Annotation được hiểu là một dạng chú thích hoặc  một dạng siêu dữ liệu (metadata) được dùng để cung cấp thông tin dữ liệu cho mã nguồn Java. Các chú thích không có ảnh hưởng trực tiếp đến hoạt động của mã mà chúng chú thích. Annotation được thêm vào Java từ Java 5. Các Annotation được sử dụng trong mã nguồn sẽ được biên dịch thành bytecode và sử dụng kỹ thuật phản chiếu (Reflection) để truy vấn thông tin siêu dữ liệu và đưa ra hành động thích hợp.Chúng ta có thể chú thích các lớp (class), phương thức (method), các biến (variable), các gói (package) và các tham số (prameter) trong Java.

Java Annotation có hai loại:

* Các Annotation được tích hợp sẵn.
* Annotation do người dùng tự định nghĩa.

## 2. Cấu trúc của một Annotation trong Java

Một chú thích luôn bắt đầu với ký hiệu @ và sau đó là tên của chú thích. Ký hiệu @ chỉ ra cho trình biên dịch rằng đây là một chú thích.

Ví dụ: @Deprecated

* Ký hiệu @ mô tả đây là một chú thích.
* Deprecated là tên của chú thích.

## 3. Chức năng của Annotation trong Java

Annotation được sử dụng trong Java cho 3 mục đích chính:

### Thứ nhất, chỉ dẫn cho trình biên dịch (Compiler)

Chú thích có thể được trình biên dịch sử dụng để phát hiện lỗi hoặc triệt tiêu các cảnh báo. Java có 3 Annotation có thể được sử dụng nhằm cung cấp chỉ dẫn cho trình biên dịch:

1. @Deprecated

2. @Override

3. @SuppressWarnings

Chi tiết về từng chú thích sẽ được giải thích chi tiết trong phần sau. 

### Thứ hai, chỉ dẫn trong thời điểm biên dịch (Build-time)

Các công cụ phần mềm có thể thông qua các chỉ dẫn của chú thích để tạo mã nguồn, tệp XML, nén mã biên dịch và các tâp tin vào một tập tin, v…v

### Thứ ba, chỉ dẫn trong thời gian chạy (Runtime)

Thông thường, các Annotation không có mặt trong mã Java sau khi biên dịch. Tuy nhiên, có thể xác định trong thời gian chạy bằng cách sử dụng kỹ thuật Reflection và có thể sử dụng để đưa ra những hướng dẫn cho chương trình trong thời gian chạy.

## 4. Các Annotation tích hợp sẵn trong Java và ví dụ minh họa

Annotation tích hợp sẵn có hai loại:
### 4.1. Java Annotation được tích hợp để sử dụng trực tiếp trong code Java:

Chúng ta có 3 Annotation quan trọng:

* @Override:  
Được sử dụng cho các phương thức có nghĩa là ghi đè một phương thức trong lớp cha (supperclass). Nếu một phương thức đánh dấu @Override không ghi đè chính xác một phương thức trong lớp cha của nó hay hiểu đơn giản là phương thức đó không hợp lệ thì trình biên dịch sẽ báo lỗi. Chúng ta không nhất thiết phải sử dụng @Override khi ghi đè phương thức, nhưng Annotation này sẽ giúp chúng ta tránh lỗi dễ dàng hơn.
    Ví dụ: 

```java 
public class superExampleNMD {
    public void methodOverride() {
        System.out.println("SupperClass Nguyen Minh Duc");
    }
}
```

```java 
public class ExampleNMD extends superExampleNMD{
    @Override
    public void methodOverride() {
        System.out.println("SubClass Nguyen Minh Duc");
    }
}
```

```java 
public class MainNMD {
    public static void main(String[] args) {
        ExampleNMD ex = new ExampleNMD();
        ex.methodOverride();
    }    
}
```

Chúng ta có thể thấy rằng phương thức ở lớp con đã ghi đè nội dung lên phương thức của lớp cha.

* @Deprecated    

Được sử dụng để dánh dấu một đối tượng (class, method hoặc field) và chỉ dẫn rằng nó tốt nhất không nên được sử dụng nữa. Trình biên dịch sẽ đưa các câu cảnh báo khi chương trình sử dụng các thuộc tính, lớp hoặc phương thức có gắn với @Deprecated.



* @SuppressWarnings

      Thông báo cho trình biên dịch biết là không được in các câu cảnh báo nào đó.      
      Cú pháp sử dụng: @SuppressWarnings("...") hoặc @SuppressWarnings({"...","...",v...v...}) trong "..." được hiểu là tên các loại cảnh báo.
      Chúng ta thường dùng: 

  * @SuppressWarnings(“deprecation”) để thông báo trình biên dịch không cảnh báo việc sử dụng phương thức có sử dụng @Deprecated.

  * @SuppressWarnings(“unchecked”) để thông báo trình biên dịch không cảnh báo việc sử một ép kiểu không an toàn.

  * @SuppressWarnings(“rawtypes”) để thông báo trình biên dịch không cảnh báo lỗi trong khai báo kiểu dữ liệu.

### 4.2. Java Annotation được tích hợp sẵn được sử dụng trong Annotation khác.

* @Target: Dùng để chú thích phạm vi sử dụng của một Annotation.  Các chú thích này đã được định nghĩa trong enum java.lang.annotation.ElementType:


|ElementType.TYPE | Chú thích trên Class, interface, enum, annotation|
|----|---|
|ElementType.FIELD |Chú thích trường (field), bao gồm cả các hằng số enum.|
|ElementType.METHOD |Chú thích trên method.|
|ElementType.PARAMETER |Chú thích trên parameter.|
|ElementType.CONSTRUCTOR |Chú thích trên constructor.|
|ElementType.LOCAL_VARIABLE |Chú thích trên biến địa phương.|
|ElementType.ANNOTATION_TYPE |Chú thích trên Annotation khác.|
|ElementType.PACKAGE|Chú thích trên package.|

* @Retention: Dùng để chú thích mức độ tồn tại của một Annotation nào đó. Cụ thể có 3 mức nhận thức tồn tại của vật được chú thích, và được định nghĩa trong enum java.lang.annotation.RetentionPolicy:


|RetentionPolicy.SOURCE| 	Tồn tại trên mã nguồn, và không được trình biên dịch nhận ra.|
|---|---|
|RetentionPolicy.CLASS |	Mức tồn tại được trình biên dịch nhận ra, nhưng không được nhận biết bởi máy ảo tại thời điểm chạy (Runtime).|
|RetentionPolicy.RUNTIME |	Mức tồn tại lớn nhất, được trình biên dịch nhận biết, và máy ảo (JVM) cũng nhận ra khi chạy chương trình.|


* @Inherited: Chú thích này chỉ ra rằng chú thích mới nên được bao gồm trong tài liệu Java được tạo ra bởi các công cụ tạo tài liệu Java.
* @Documented: Chú thích chỉ ra rằng loại chú thích có thể được kế thừa từ lớp cha và có giá trị mặc định là false. Khi người dùng truy vấn kiểu Annotation của lớp con và lớp con không có chú thích cho kiểu này thì lớp cha của lớp được truy vấn cho loại chú thích sẽ được gọi. Chú thích này chỉ áp dụng cho các khai báo class.

## 5. Khởi tạo Annotation (Annotation tự định nghĩa)

Annotation khá giống một interface, để khai báo một Annotation chúng ta sử dụng @interface. Annotation có thể có hoặc không có các phần tử (element) trong đó.

Một phần tử của Annotation có các đặc điểm như sau:

1. Không có thân hàm
2. Không có tham số hàm
3. Khai báo trả về phải là một kiểu dữ liệu cụ thể (Kiểu nguyên thủy, Enum, Annotation hoặc Class).
4. Có thể có giá trị mặc định.

Một Annotation sẽ đượng định nghĩa bởi các Meta-Annotations. Các Meta-Annotations gồm @Retention, @Target, @Documented, @Inherited. 

Ví dụ: 

Khởi tạo

```JAVA
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Retention(value = RetentionPolicy.SOURCE)
//Nó tồn tại trên mã nguồi và trình biên dịch không nhận ra
@Target(value = {ElementType.METHOD, ElementType.FIELD})
//Nó sẽ được dùng chú thích tren mot method
public @interface MyCustomAnnotation{    
}
```

Sử dụng

```java
public class UsingAnno {
    @MyCustomAnnotation  //Gán trước một field
    private int myAge = 22;    
    
    @MyCustomAnnotation   //Gán trước một method
    public void aMethod(){
        
    }
}
```

Trên là một ví dụ nhằm có cái nhìn cơ bản về cách khởi tạo một Annotation.
## 6. Annotation lồng nhau (lặp lại chú thích) và cách sử dụng

Trong một số trường hợp, nhu cầu sử dụng một Annotation nhiều lần. Khi đó chúng ta cần tạo một Wrapper chứa danh sách các Annotation có thể lặp lại.

Ví dụ: 

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestAnnotationMain {

    // 1. Koi tao mot chu thich can lap lai
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ReAnno {

        String value();
    };

    // 2. Khoi tao mot chu thich long nhau
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ReAnnos {

        ReAnno[] value();
    }

    // 3. Use repeating annotations
    @ReAnnos({
        @ReAnno("Codelearn"),
        @ReAnno("NMD.SE")})
    public interface ReAnnotation {
    }

    public static void main(String[] args) {
        // 4. Retrieving Annotations via the Filters class
        ReAnnos rep = ReAnnotation.class.getAnnotation(ReAnnos.class);
        for (ReAnno re : rep.value()) {
            System.out.println(re.value());
        }
    }
}

```

## 7.Các kiểu của annotation

Có 3 kiểu của annotation:

1. Marker Annotation
2. Single-Value Annotation
3. Multi-Value Annotation

### 7.1. Marker Annotation

Một annotation không có phương thức được gọi là marker annotation. Ví dụ: 

```java
@interface MyAnnotation{}
```

 @Override và @Deprecated là các maker annotation.

### 7.2. Single-Value Annotation

Một annotation mà có một phương thức được gọi là single-value annotation. Ví dụ: 

```java
@interface MyAnnotation {
    int value();
}
```

Bạn cũng có thể cung cấp giá trị mặc định, ví dụ: 

```java
@interface MyAnnotation {
    int value() default 0;
}
```
Làm thế nào để áp dụng Single-Value Annotation

Ví dụ sử dụng Single-Value Annotation: 

```java
@MyAnnotation(value = 10)
```

value có thể là những giá trị khác.

### 7.3. Multi-Value Annotation

Một annotation mà có nhiều hơn một phương thức được gọi là Multi-Value annotation. Ví dụ: 

```java
@interface MyAnnotation {
    int value1();
 
    String value2();
 
    String value3();
}
```
Bạn cũng có thể cung cấp giá trị mặc định, ví dụ: 

```java
@interface MyAnnotation {
    int value1() default 1;
 
    String value2() default "";
 
    String value3() default "xyz";
}
```

Làm thế nào để áp dụng Multi-Value Annotation

Ví dụ sử dụng Multi-Value Annotation: 

```java
@MyAnnotation(value1 = 10, value2 = "Hello", value3 = "Java")
```

## Ref
* https://viettuts.vn/java-new-features/tuy-chinh-annotation-trong-java
* https://codelearn.io/sharing/annotation-trong-java-la-gi