package com.java8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
// Annotation này nói rằng AnnFM chỉ được nhận biết trên mã nguồn.
// Nó sẽ không được nhận biết bởi bộ biên dịch (compiler),
// và trong thời gian chạy máy ảo cũng không biết sự tồn tại của nó.
@Retention(value = RetentionPolicy.SOURCE)
// Annotation này nói rằng:
// AnnFM sẽ chỉ được dùng để chú thích (annotate) trên FIELD hoặc METHOD.
@Target(value = { ElementType.FIELD, ElementType.METHOD })
public @interface AnnFM2 {

}