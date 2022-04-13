package com.bhh.datastructure.graph.traverse.dfs;

import com.bhh.datastructure.graph.base.SparseGraph;

/**
 * @author bhh
 * @description 关于图的深度遍历, 以及图的连通性
 * @date Created in 2021-09-27 16:06
 * @modified By
 */
public class DFS {
    private SparseGraph graph;
    private boolean[] visited;
    private int ccount;
    private int[] id;

    public DFS(SparseGraph graph) {
        this.graph = graph;
        this.ccount = 0;
        this.visited = new boolean[graph.V()];
        this.id = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            id[i] = -1;
        }

        // 求图的连通分量
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    /**
     * DFS遍历
     *
     * @param i
     */
    private void dfs(int i) {
        visited[i] = true;
        id[i] = ccount;
        for (Integer index : graph.adj(i)) {
            if (!visited[index]) {
                dfs(index);
            }
        }
    }

    public int getCount() {
        return ccount;
    }

    public boolean isConnect(int v, int w) {
        return id[v] == id[w];
    }
}
