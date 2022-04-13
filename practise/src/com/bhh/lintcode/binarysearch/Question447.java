package com.bhh.lintcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author bhh
 * @description TODO
 * @date Created in 2021-11-28 17:00
 * @modified By
 */
public class Question447 {
    public class Solution {
        /**
         * @param reader: An instance of ArrayReader.
         * @param target: An integer
         * @return: An integer which is the first index of target.
         */
        public int searchBigSortedArray(ArrayList<Integer> reader, int target) {
            // 先指定start和end范围
            int rangeTotal = 1;
            while (reader.get(rangeTotal - 1) < target) {
                rangeTotal *= 2;
            }

            int start = rangeTotal / 2, end = rangeTotal - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (reader.get(mid) > target) {
                    end = mid - 1;
                }else if (reader.get(mid) < target){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }
            if (reader.get(start) == target){
                return start;
            }
            if (reader.get(end) == target){
                return end;
            }
            return -1;
        }
    }
}
