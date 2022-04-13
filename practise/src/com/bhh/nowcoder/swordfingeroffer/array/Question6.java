package com.bhh.nowcoder.swordfingeroffer.array;

/**
 * @author bhh
 * @description 描述
 * 有一个长度为N的升序数组，比如[1,2,3,4,5]，将它进行旋转，
 * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 请问，给定这样一个旋转数组，求它的最小值。
 * <p>
 * <p>
 * 提示:
 * 1 <= N<= 10000
 * 0 <= rotateArray[i] <= 10000
 * 你可以使用O(logN)的时间复杂度通过该题吗?
 * 示例1
 * 输入：
 * [3,4,5,1,2]
 * 返回值：
 * 1
 * @date Created in 2021-09-10 11:38
 * @modified By
 */
public class Question6 {

    class Solution {
        /**
         * 实现思路 :
         * 方法1 : 遍历数组获取数组开始变小时的索引位置, 该索引指定位置是最小值
         *
         * @param array
         * @return
         */
        /*public int minNumberInRotateArray(int[] array) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    return array[i];
                }
            }
            return array[0];
        }*/

        /**
         * 实现思路 :
         *      方法2 :
         *      获取数组首位的值
         *      通过二分查找查找 小于该值 的值对应的索引
         *      获取该值
         *      循环查找 小于该值 的值对应的索引
         *      直到 l==r
         *
         * @param array
         * @return
         */
//        public int minNumberInRotateArray(int[] array) {
//            int l = 0;
//            int r = array.length - 1;
//            while (l < r){
//                int mid = l + (r - l) / 2;
//                if (array[mid] > array[r]){
//                    l = mid + 1;
//                }else if (array[mid] < array[]){
//                    min = array[mid];
//                    r = mid - 1;
//                }else{
//                    l++;
//                }
//            }
//            return min;
//        }
    }

    public static void main(String[] args) {
        Solution test = new Question6().new Solution();
        int[] array = new int[]{2,2,2,1,2};
//        System.out.println(test.minNumberInRotateArray(array));
    }
}