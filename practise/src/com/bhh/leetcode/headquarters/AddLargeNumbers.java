package com.bhh.leetcode.headquarters;

import java.math.BigDecimal;

/**
 * @author bhh
 * @description 大数相加
 * @date Created in 2021-09-10 10:35
 * @modified By
 */
public class AddLargeNumbers {
    /**
     * 方法一 : 直接使用 BigDecimal 来完成大数相加
     *
     * @param s1
     * @param s2
     * @return 返回String
     */
    public String add2Sum1(String s1, String s2) {
        System.out.println("---------------");
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);
        return b1.add(b2).toString();
    }

    /**
     * 方法二 : 使用String 来完成大数相加
     * 实现思路 :
     * 俩个字符串进行反转
     * 补齐字符串, 短的字符串高位补齐0
     * 低位相加 (获取俩个字符串的最长长度, 遍历) , 若是和大于10, 则进 1到高位
     * 某一个字符串高位为空, 则为0
     * 逆序输出
     *
     * @param s1
     * @param s2
     * @return
     */
    public String add2Sum2(String s1, String s2) {

        // 字符串反转
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();


        int length1 = s1.length();
        int length2 = s2.length();
        int max = length1;

        // 将低位数向高位补齐0
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                s2 += "0";
            }
        } else {
            for (int i = 0; i < length2 - length1; i++) {
                s1 += "0";
            }
            max = length2;
        }

        // 相加
        StringBuilder res = new StringBuilder();
        int one = 0;
        for (int i = 0; i < max; i++) {
            int sum = Integer.parseInt(String.valueOf(s1.charAt(i))) +
                    Integer.parseInt(String.valueOf(s2.charAt(i))) + one;
            res.append(sum % 10);
            one = sum / 10;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddLargeNumbers add = new AddLargeNumbers();
        System.out.println("res1 = " +
                add.add2Sum1("123457891011121314151617181920", "2019181716151413121110987654321"));
        System.out.println("res2 = " +
                add.add2Sum2("123457891011121314151617181920", "2019181716151413121110987654321"));
    }
}
