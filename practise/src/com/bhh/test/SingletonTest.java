package com.bhh.test;

import java.util.EnumSet;

/**
 * @author bhh
 * @description 单例模式
 * 双重检查锁机制
 * @date Created in 2021-09-05 16:10
 * @modified By
 */
public class SingletonTest {
    private static volatile SingletonTest test;
    public static Object obj = new Object();

    public static SingletonTest getInstance() {
        if (test == null) {
            synchronized (obj) {
                if (test == null) {
                    test = new SingletonTest();
                }
            }
        }
        return test;
    }
}
