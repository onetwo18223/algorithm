package com.bhh.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1 {

    // 创建对象便于bfs使用
    class Offset {
        long x, y;
        int count;

        Offset(long x, long y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    // bfs/dfs
    public long GetMinCalculateCount(long sourceX, long sourceY,
                                     long targetX, long targetY) {
        if (sourceX == targetX && sourceY == targetY) {
            return 0;
        }
        Queue<Offset> queue = new ArrayDeque<>();
        queue.add(new Offset(sourceX, sourceY, 0));
        while (!queue.isEmpty()) {
            Offset element = queue.poll();
            if (element.x == targetX && element.y == targetY) {
                return element.count;
            }
            if (element.x > targetX || element.y > targetY) {
                return -1;
            }
            queue.add(new Offset(element.x + 1, element.y + 1, element.count + 1));
            queue.add(new Offset(element.x * 2, element.y * 2, element.count + 1));
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().GetMinCalculateCount(Long.MAX_VALUE, 0, Long.MIN_VALUE, 0));
    }
}