package com.bhh.test;

import java.util.Scanner;

public class Main {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 读取组数
//        int count = in.nextInt();
//        while (count != 0) {
//            // 读取长度
//            int len = in.nextInt();
//            int[] nums = new int[len];
//            // 赋值
//            for (int i = 0; i < len; i++) {
//                nums[i] = Integer.valueOf(in.next());
//            }
//            // 排序
//            Arrays.sort(nums);
//            // 三数之和变化
//            // 使用双指针
//            boolean judge = true;
//            for (int i = 0; i < len - 2; i++) {
//                // 判断当前元素 + 下一个元素 和 结尾元素
//                int twoSum = nums[i] + nums[i + 1];
//                if (twoSum <= nums[len - 1]) {
//                    judge = false;
//                }
//            }
//            if (judge) {
//                System.out.println("N");
//            } else {
//                System.out.println("YES");
//            }
//            count--;
//        }
//    }
//    public static void main(String[] args) {
//        // 先求全部总和
//        int sum = 0;
//        for (int i = 0; i < 26; i++) {
//            sum += 'A' + i;
//        }
//
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        char[] cNums = str.toCharArray();
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < cNums.length; i++) {
//            set.add(cNums[i]);
//        }
//        for (Character character : set) {
//            sum -= character;
//        }
//        System.out.println(sum);
//    }

    // 使用dp解决，升级的地方在于这是一个矩阵
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rowLen = sc.nextInt();
        int lineLen = sc.nextInt();
        int[][] nums = new int[rowLen][lineLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < lineLen; j++) {
                nums[i][j] = Integer.valueOf(sc.next());
            }
        }

        if (rowLen == 0) {
            System.out.println(1);
            return;
        }

        // 创建dp
        // 0表示不摆摊， 1表示摆摊
        int[][][] dp = new int[rowLen + 1][lineLen + 1][2];
        for (int i = 1; i < rowLen + 1; i++) {
            for (int j = 1; j < lineLen + 1; j++) {
                // 当前不摆摊
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]) +
                        Math.max(dp[i][j - 1][0], dp[i][j - 1][1]) + 1;
                // 摆摊
                if (nums[i - 1][j - 1] != 0) {
                    dp[i][j][1] = dp[i - 1][j][0] + dp[i][j - 1][0] + 1;
                }
            }
        }

        System.out.println((dp[rowLen][lineLen][0] + dp[rowLen][lineLen][1]) % 987654321);
    }
}
