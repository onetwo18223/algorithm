package org.problem.twopointer.copointer.sliding;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 */
public class OfferQuestion57 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if (target == 0) {
                return new int[0][];
            }
            ArrayList<ArrayList<Integer>> arrayList = new ArrayList();
            int start = 1, end = 1;
            int sum = 0;
            while (end < target) {
                if (sum == target) {
                    ArrayList<Integer> list = new ArrayList();
                    for (int i = start; i < end; i++) list.add(i);
                    arrayList.add(list);
                    sum -= start++;
                } else if (sum > target) {
                    sum -= start++;
                } else sum += end++;
            }
            return toArrayMethod2(arrayList);
        }

        public Integer[][] toArrayMethod1(ArrayList<ArrayList<Integer>> list) {
            List<Integer[]> tempList = new ArrayList<>();
            for (List<Integer> subList : list) {
                // 如何使用toArray
//            tempList.add((Integer[])subList.toArray());
                tempList.add(subList.toArray(new Integer[0]));
            }
            return tempList.toArray(new Integer[0][]);
        }

        public int[][] toArrayMethod2(ArrayList<ArrayList<Integer>> arrayList) {
            int listSize = arrayList.size();
            int[][] nums = new int[listSize][];
            for (int i = 0; i < listSize; i++) {
                ArrayList<Integer> sublist = arrayList.get(i);
                int sublistSize = sublist.size();
                nums[i] = new int[sublistSize];
                for (int j = 0; j < sublistSize; j++) {
                    nums[i][j] = sublist.get(j);
                }
            }
            return nums;
        }
    }

    /**
     * 双层ArrayList转换为E[]类型二维数组
     * 转换的核心思想是将单层的ArrayList转换为数组
     * 现将内层ArrayList转为数组 toArray
     * 再重新写入到外层的ArrayList<数组[]>之中
     * 最后再将外层的ArrayList转为数组 toArray
     *
     * @param list
     * @return
     */
    public Integer[][] toArrayMethod1(ArrayList<ArrayList<Integer>> list) {
        List<Integer[]> tempList = new ArrayList<>();
        for (List<Integer> subList : list) {
            // 如何使用toArray
//            tempList.add((Integer[])subList.toArray());
            tempList.add(subList.toArray(new Integer[0]));
        }
        return tempList.toArray(new Integer[0][]);
    }

    /**
     * 如果需要返回int这种数据类型的数组类型，
     * 需要使用将集合数据挨个遍历然后写入数组
     *
     * @param arrayList
     * @return
     */
    public int[][] toArrayMethod2(ArrayList<ArrayList<Integer>> arrayList) {
        int listSize = arrayList.size();
        int[][] nums = new int[listSize][];
        for (int i = 0; i < listSize; i++) {
            ArrayList<Integer> sublist = arrayList.get(i);
            int sublistSize = sublist.size();
            nums[i] = new int[sublistSize];
            for (int j = 0; j < sublistSize; j++) {
                nums[i][j] = sublist.get(j);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new OfferQuestion57().new Solution();
        int[][] a = solution.findContinuousSequence(9);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println("");
        }
    }
}
