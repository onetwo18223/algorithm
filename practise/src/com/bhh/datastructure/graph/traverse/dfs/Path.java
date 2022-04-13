package com.bhh.datastructure.graph.traverse.dfs;

import com.bhh.datastructure.graph.base.SparseGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bhh
 * @description 通过dfs实现, 选取一个起始点, 判断路径
 * @date Created in 2021-09-27 16:35
 * @modified By
 */
public class Path {
    // 图实例
    private SparseGraph graph;
    // 判断节点是否被访问
    private boolean[] visited;
    // 存储上一个被访问的节点, 例如 : pre[i] 是上一个被访问的节点
    private int[] pre;
    // 起始点索引
    int s;

    public Path(SparseGraph graph, int s) {
        // 初始化
        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.V()];
        pre = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            pre[i] = -1;
        }

        // 寻路算法
        dfs(s);
    }

    // 图的深度优先遍历
    void dfs(int v) {
        visited[v] = true;

        for (int index : graph.adj(v)) {
            if (!visited[index]){
                pre[index] = v;
                dfs(index);
            }
        }
    }

    /**
     * 判断从s到w是否有路劲
     * @param w
     * @return
     */
    public boolean hasPath(int w){
        return visited[w];
    }

    /**
     * 获取从s到w的路径
     * @param w
     * @return
     */
    public List<Integer> path(int w){
        List<Integer> list = new ArrayList();
        while (w != -1){
            list.add(w);
            w = pre[w];
        }
        // 翻转可以使用 Collections.reverse(list), 也可以使用栈完成
        Collections.reverse(list);
        return list;
    }
}
