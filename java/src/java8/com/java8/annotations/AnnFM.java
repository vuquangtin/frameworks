package com.java8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>@Retention & @Target</h1>
 * 
 * @Retention & @Target là 2 annotation sẵn có của Java.
 * @Retention
 * @Retention: Dùng để chú thích mức độ tồn tại của một annotation nào đó. Cụ
 *             thể có 3 mức nhận thức tồn tại của vật được chú thích:
 *             <ul>
 *             <li>
 *             RetentionPolicy.SOURCE: Tồn tại trên code nguồn, và không được bộ
 *             dịch (compiler) nhận ra.</li>
 *             <li>RetentionPolicy.CLASS: Mức tồn tại được bộ dịch nhận ra,
 *             nhưng không được nhận biết bởi máy ảo tại thời điểm chạy
 *             (Runtime).</li>
 *             <li>RetentionPolicyRUNTIME: Mức tồn tại lớn nhất, được bộ dịch
 *             (compiler) nhận biết, và máy ảo thời điểm chạy cũng nhận ra sự
 *             tồn tại của nó.</li>
 *             </ul>
 * @Target<br/>
 * @Target: Dùng để chú thích cho một annotation khác, và annotation đó sẽ được
 *          sử dụng trong phạm vi nào.
 *          <ul>
 *          <li>ElementType.TYPE - Gắn trên khai báo Class, interface, enum,
 *          annotation.</li>
 *          <li>ElementType.FIELD - Gắn trên khai báo trường (field), bao gồm cả
 *          các hằng số enum.</li>
 *          <li>ElementType.METHOD - Gắn trên khai báo method.</li>
 *          <li>ElementType.PARAMETER - Gắn trên khai báo parameter</li>
 *          <li>ElementType.CONSTRUCTOR - Gắn trên khai báo cấu tử</li>
 *          <li>ElementType.LOCAL_VARIABLE - Gắn trên biến địa phương.</li>
 *          <li>ElementType.ANNOTATION_TYPE - Gắn trên khai báo Annotation</li>
 *          <li>ElementType.PACKAGE - Gắn trên khai báo package.</li>
 *          </ul>
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 * @see https://o7planning.org/vi/10197/huong-dan-java-annotation
 */
// Annotation này nói rằng AnnFM chỉ được nhận biết trên mã nguồn.
// Nó sẽ không được nhận biết bởi bộ biên dịch (compiler),
// và trong thời gian chạy máy ảo cũng không biết sự tồn tại của nó.
@Retention(value = RetentionPolicy.SOURCE)
// Annotation này nói rằng:
// AnnFM sẽ chỉ được dùng để chú thích (annotate) trên FIELD hoặc METHOD.
@Target(value = { ElementType.FIELD, ElementType.METHOD })
public @interface AnnFM {

}
