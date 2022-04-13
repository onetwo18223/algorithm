package com.bhh.nowcoder.swordfingeroffer.array;

import java.util.Arrays;

/**
 * @author bhh
 * @description 数组中的逆序对
 * @date Created in 2021-09-10 20:47
 * @modified By
 */
public class Question35 {
    public class Solution {
        /**
         * 暴力解法, 超时
         * @param array
         * @return
         */
        /*public int InversePairs(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }

            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        sum++;
                    }
                }
            }
            return sum;
        }*/

        /**
         * 使用递归实现
         * 实现思路 :
         * 每一次在merge时, 进行判断若是有左边集合索引对应的值大于右边集合索引对应的值
         * 则 sum ++;
         *
         * @param array
         * @return
         */
        public int InversePairs(int[] array) {
            if (array == null || array.length == 0) {
                return 0;
            }
            int sum = 0;
            return sort(array, 0, array.length - 1, sum);
        }

        public int sort(int[] data, int l, int r, int sum) {
            if (l >= r) {
                return sum;
            }
            int mid = l + (r - l) / 2;
            sum += sort(data, l, mid, sum);
            sum += sort(data, mid + 1, r, sum);
            return merge(data, l, mid, r, sum);
        }

        private int merge(int[] data, int l, int mid, int r, int sum) {
            int[] temp = Arrays.copyOfRange(data, l, r + 1);
            int s = l;
            int b = mid + 1;

            for (int i = s; i <= mid; i++) {
                /*
                每一个关于s的数组都需要和关于b的数组进行比较,
                如果s的数组中的元素大于关于b中的数组元素, 则sum++
                 */
                for (int j = b; j <= r; j++) {
                    if (temp[i - l] > temp[j - l]) {
                        sum++;
                    }
                }
            }

            for (int i = l; i <= r; i++) {
                /*
                优先考虑越界
                其次比较大小
                当左边大于右边(s>b)时, sum++
                 */
                if (s > mid) {
                    data[i] = temp[b - l];
                    b++;
                } else if (b > r) {
                    data[i] = temp[s - l];
                    s++;
                } else if (temp[s - l] < temp[b - l]) {
                    data[i] = temp[s - l];
                    s++;
                } else {
                    data[i] = temp[b - l];
                    b++;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution test = new Question35().new Solution();
        System.out.println(test.InversePairs(new int[]{
                364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575}));
    }
}
