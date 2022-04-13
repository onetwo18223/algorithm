package com.bhh.test;

/**
 * @author bhh
 * @description
 * Enum单例模式
 * @date Created in 2021-09-05 16:16
 * @modified By
 */
public enum EnumSingetonTest {
    INSTANCE;
    public static EnumSingetonTest getInstance(){
        return INSTANCE;
    }
}
