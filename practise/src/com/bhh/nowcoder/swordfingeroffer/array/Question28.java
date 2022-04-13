package com.bhh.nowcoder.swordfingeroffer.array;

/**
 * @author bhh
 * @description 描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * TODO : 没有空情况
 * 1<=数组长度<=50000，
 * 0<=数组元素<=10000
 * 示例1
 * 输入：
 * [1,2,3,2,2,2,5,4,2] length = 9, num = 4, res = 2
 * 返回值：
 * 2
 * 示例2
 * 输入：
 * [3,3,3,3,2,2,2] length = 7, num = 4, res = 3
 * 返回值：
 * 3
 * 示例3
 * 输入：
 * [1] length = 1, num = 1, res = 1
 * 返回值：
 * 1
 * @date Created in 2021-09-10 14:27
 * @modified By
 */
public class Question28 {
    public class Solution {

        /*public int MoreThanHalfNum_Solution(int[] array) {
            Map<Integer, Integer> map = new HashMap<>();

            // 遍历数组, 将数据都添加到HashMap中
            for (int i = 0; i < array.length; i++) {
                map.put(array[i], map.getOrDefault(array[i], 0) + 1);
                if (map.get(array[i]) > array.length / 2) {
                    return array[i];
                }
            }
            return 0;
        }*/

        /**
         * 实现思路
         * 使用 HashMap
         * 遍历集合, 将集合中的数据扔进 HashMap
         *      需要记录次数, 使用value记录次数
         *
         * @param array
         * @return
         */
        /*public int MoreThanHalfNum_Solution(int [] array) {
            Map<Integer, Integer> map = new HashMap<>();

            // 遍历数组, 将数据都添加到HashMap中
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])){
                    map.put(array[i], map.get(array[i]) + 1);
                }else{
                    map.put(array[i], 1);
                }
            }

            // 遍历HashMap, 获取value值, 判断value值, 获取大于array.length/2的key
            int maxValue = 0;
            int maxKey = 0;
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() > maxValue){
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            return maxKey;
        }*/

        /**
         * 实现思路 :
         * 消消乐, 求得是数组的众数, 且这个众数是会大于数组长度的一半
         * 那么我们就可以将相邻的俩个不同数进行消除
         * 最坏结果就是消除一个众数和一个非众数
         * 最终剩余的一定是非众数
         *
         * @param array
         * @return
         */
        public int MoreThanHalfNum_Solution(int[] array) {
            if (array == null || array.length == 0) {
                return -1;
            }

            // 定义众数和出现的次数
            int mode = array[0];
            int times = 1;
            for (int i = 1; i < array.length; i++) {
                // 如果上一轮比较致使times == 0, 则使用新的 array[i], continue->
                // 也就是说每俩个元素一次比较
                if (times == 0) {
                    mode = array[i];
                    times = 1;
                    continue;
                }
                if (mode != array[i]){
                    times = times - 1;
                }else{
                    times = times + 1;
                }
            }
            return mode;
        }
    }

    public static void main(String[] args) {
        Solution test = new Question28().new Solution();
        System.out.println(
                test.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
