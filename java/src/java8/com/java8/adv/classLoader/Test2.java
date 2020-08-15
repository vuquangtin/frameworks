package com.java8.adv.classLoader;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class Test2 {
    static {
        System.out.println("静态初始块执行了");
    }
    public void print(){
        System.out.println("方法一");
    }
}