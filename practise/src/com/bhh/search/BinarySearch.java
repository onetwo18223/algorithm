package com.bhh.search;

/**
 * @author bhh
 * @description 二分查找
 * @date Created in 2021-07-30 10:58
 * @modified By
 */
public class BinarySearch {
    public int get(int[] arr, int target) {
//        return get(arr, 0, arr.length - 1, target);
//        return getR(arr, 0, arr.length - 1, target);
//        return getUpper(arr, 0, arr.length - 1, target);
        return getLower(arr, 0, arr.length - 1, target);
//        return getMR(arr, 0, arr.length - 1, target);
//        return getML(arr, 0, arr.length - 1, target);
//        return getM(arr, 0, arr.length - 1, target);
    }

    // 二分查找, 递归方式
    private int getR(int[] arr, int l, int r, int target) {
        if (l <= r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            return getR(arr, l, mid - 1, target);
        }
        return getR(arr, mid + 1, r, target);
    }

    // 二分查找, 非递归
    private int get(int[] arr, int l, int r, int target) {

        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 二分查找, 模板
    private int getM(int[] arr, int l, int r, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // while结束条件为 l == r, 所以结束后再判断一次
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        if (arr[l] == target) {
            return l;
        }
        return -1;
    }

    // 二分查找, 模板, 查找最右边索引的值
    private int getMR(int[] arr, int l, int r, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // while结束条件为 l + 1 == r, 所以结束后需要依次判断arr[r]和arr[l]
        // 避免发生死循环
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                // arr[mid] == target, 但是并不意味着这是最右边的值
                l = mid;
            }
        }

        if (arr[r] == target) {
            return r;
        }
        if (arr[l] == target) {
            return l;
        }
        return -1;
    }

    // 二分查找, 模板, 查找最左边索引的值
    private int getML(int[] arr, int l, int r, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // while结束条件为 l + 1 == r, 所以结束后需要依次判断arr[l]和arr[r]
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                // arr[mid] == target, 但是并不意味着这是最左边的值
                r = mid;
            }
        }

        if (arr[l] == target) {
            return l;
        }
        if (arr[r] == target) {
            return r;
        }
        return -1;
    }

    // 二分查找获取大于target的最小值, upper, 非递归
    private int getUpper(int[] arr, int l, int r, int target) {

        // 若是最大值小于 target 则, 直接返回-1
        if (arr[r] < target) {
            return -1;
        }

        // 结束条件为 l == r
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            // 大于target的, 需要进行保留, 因为符合一部分条件
//            if (arr[mid] > target) {
//                r = mid;
//            } else if (arr[mid] <= target) {
//                l = mid + 1;
//            }
//        }
        // 为了避免 计算mid而导致的死循环情况, 判断条件改为 l + 1 < r
        // 结束条件为 l + 1 == r
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            // 大于target的, 需要进行保留, 因为符合一部分条件
            if (arr[mid] > target) {
                r = mid;
            } else if (arr[mid] <= target) {
                l = mid + 1;
            }
        }
        if (arr[l] > target) {
            return l;
        }
        if (arr[r] > target) {
            return r;
        }
        return -1;
    }

    // 二分查找获取小于target的最大值, lower, 非递归
    private int getLower(int[] arr, int l, int r, int target) {

        // 若是最小值大于 target 则, 直接返回-1
        if (arr[l] > target) {
            return -1;
        }

        // 结束条件为 l == r
//        while (l < r) {
//            int mid = l + (int) Math.ceil((r - l) / 2.0);
//            if (arr[mid] >= target) {
//                r = mid - 1;
//                // 小于target的, 需要进行保留, 因为符合一部分条件
//            } else if (arr[mid] < target) {
//                l = mid;
//            }
//        }
        // 为了避免mid造成的死循环, 判断条件为 l + 1 < r
        // 结束条件为 l + 1 == r
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid - 1;
                // 小于target的, 需要进行保留, 因为符合一部分条件
            } else if (arr[mid] < target) {
                l = mid;
            }
        }
        if (arr[r] < target) {
            return r;
        }
        if (arr[l] < target) {
            return l;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch test = new BinarySearch();
        int[] arr = new int[]{0, 1, 2, 2, 2, 3, 4, 5};
        System.out.println("test.get(arr, 2) = " + test.get(arr, 2));
        System.out.println("test.get(arr, 3) = " + test.get(arr, 3));
        System.out.println("test.get(arr, 6) = " + test.get(arr, 6));
    }
}
