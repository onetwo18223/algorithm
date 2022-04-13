package com.bhh.lintcode.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author bhh
 * @description 单词接龙
 * @date Created in 2021-12-10 12:30
 * @modified By
 */
public class Question120 {
    public class Solution {
        /*
        单词接龙,
        为每一个列出所有接住的可能
            例如 : start ="hit", end = "cog"
            dict =["hot","dot","dog","lot","log"]
            hit : 可接列表 : hot
            hot : 可接列表 : dot, lot
            dot : 可接列表 : dog, lot, hot
            dog : 可接列表 : cog, log, dot
            等等
        然后依据BFS寻找最短路径
         */
        public int ladderLength(String start, String end, Set<String> dict) {
            if (dict == null || dict.size() == 0) {
                return 0;
            }
            dict.add(end);
            Queue<String> queue = new ArrayDeque<>();
            HashSet<String> visited = new HashSet<>();
            queue.add(start);
            visited.add(start);
            int length = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String element = queue.poll();
                    if (element.equals(end)) {
                        return length;
                    }
                    for (String word : haveWords(element, dict)) {
                        if (!visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
                length++;
            }
            return 0;
        }

        /**
         * 获取和element可接龙的所有单词
         * 只允许和element有一个单词差别
         *
         * @param element
         * @param dict
         * @return
         */
        private Set<String> haveWords(String element, Set<String> dict) {
            Set<String> words = new HashSet<>();
            for (String str : dict) {
                boolean judge = false;
                for (int i = 0; i < element.length(); i++) {
                    if (element.charAt(i) != str.charAt(i)) {
                        if (judge) {
                            judge = false;
                            break;
                        }
                        judge = true;
                    }
                }
                if (judge) {
                    words.add(str);
                }
            }
            return words;
        }
    }
}
