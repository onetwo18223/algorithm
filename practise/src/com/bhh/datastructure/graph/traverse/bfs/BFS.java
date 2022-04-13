package com.bhh.datastructure.graph.traverse.bfs;

import com.bhh.datastructure.graph.base.SparseGraph;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author bhh
 * @description 通过bfs实现最短路径
 * DFS和BFS不同点在于
 * DFS会一直向下寻找节点
 * BFS只有当某一个距离的节点遍历完之后才会遍历下一个距离的节点
 * ( 依靠队列实现, 在遍历节点时会将相邻节点存储队列中 )
 * @date Created in 2021-09-27 18:30
 * @modified By
 */
public class BFS {
    private SparseGraph graph;
    private int s;
    private boolean[] visited;
    private int[] pre;
    private int[] ord;

    public BFS(SparseGraph graph, int s) {
        this.graph = graph;
        this.s = s;
        this.visited = new boolean[graph.V()];
        this.pre = new int[graph.V()];
        this.ord = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            pre[i] = -1;
            ord[i] = -1;
        }

        // 先完成遍历
        bfs(s);

    }

    public void bfs(int s) {
        Queue<Integer> queue = new ConcurrentLinkedQueue();

        queue.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!queue.isEmpty()){
            int v = queue.remove();
            for (Integer index : graph.adj(v)) {
                if (!visited[index]){
                    queue.add(index);
                    visited[index] = true;
                    pre[index] = v;
                    ord[index] = ord[v] + 1;
                }
            }
        }
    }

    public int shortPath(int w){
        return ord[w];
    }
}
