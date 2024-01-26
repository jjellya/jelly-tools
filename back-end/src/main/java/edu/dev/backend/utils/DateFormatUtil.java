package edu.dev.backend.utils;

import lombok.Getter;

import java.text.SimpleDateFormat;

/**
 * Create By  @林俊杰
 * 2022/3/29 11:30
 *
 * @version 1.0
 */

/**
 * 问题
 * SimpleDateFormat(下面简称sdf)类内部有一个Calendar对象引用,它用来储存和这个sdf相关的日期信息,例如sdf.parse(dateStr), sdf.format(date) 诸如此类的方法参数传入的日期相关String, Date等等, 都是由Calendar来储存的.
 *
 * 如果你的sdf是个static的, 那么多个thread 之间就会共享这个sdf, 同时也是共享这个Calendar引用,对这个Calendar同时操作就会导致读写不一致的情况,常见的异常有: 1.数组下标越界; 2. input为空字符串.
 *
 * 解决方案
 * 使用ThreadLocal 分别为每个线程创建独立的 SimpleDateFormat ,这样就能避免共用 Calendar 引发的问题,
 *
 *
 * ThreadLocal简介
 *
 * 多线程访问同一个共享变量的时候容易出现并发问题，
 * 特别是多个线程对一个变量进行写入的时候，为了保证线程安全，
 * 一般使用者在访问共享变量的时候需要进行额外的同步措施才能保证线程安全性。
 * ThreadLocal是除了加锁这种同步方式之外的一种保证一种规避多线程访问出现线程不安全的方法，
 * 当我们在创建一个变量后，如果每个线程对其进行访问的时候访问的都是线程自己的变量
 * 这样就不会存在线程不安全问题。
 *
 * ThreadLocal是JDK包提供的，它提供线程本地变量，
 * 如果创建一个ThreadLocal变量，那么访问这个变量的每个线程都会有这个变量的一个副本，
 * 在实际多线程操作的时候，操作的是自己本地内存中的变量，从而规避了线程安全问题，如下图所示
 *
 *
 *
*
* */
public class DateFormatUtil {
    public static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
}
