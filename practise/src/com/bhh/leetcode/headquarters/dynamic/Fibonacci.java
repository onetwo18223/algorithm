package com.bhh.leetcode.headquarters.dynamic;

/**
 * @author bhh
 * @description 斐波那契递归实现
 * @date Created in 2021-10-07 9:31
 * @modified By
 */
public class Fibonacci {
    public int sum(int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return sum(n - 1) + sum(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().sum(45));
    }
}
