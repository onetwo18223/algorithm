package com.bhh.datastructure.graph.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 邻接表
 * @date Created in 2021-09-27 11:52
 * @modified By
 */
public class SparseGraph {
    private int n;
    private int m;
    private boolean directed;
    private List<Integer>[] g;

    SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    /**
     * 返回节点数n
     *
     * @return 节点数
     */
    public int V() {
        return n;
    }

    /**
     * 返回边数m
     *
     * @return
     */
    public int E() {
        return m;
    }

    /**
     * 获取数组
     * @return
     */
    public List<Integer>[] getG(){
        return g;
    }

    /**
     * 添加一个从v到w的边
     * 若是在addEdge()中使用hahEdge(), 则时间复杂度会从O(1)到O(n),
     * 所以邻接表可以放弃判断平行边, 或者在所有边加载完成之后进行同一判断
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        if (v < 0 || v > n || w < 0 || w > n) {
            throw new RuntimeException("参数异常");
        }
        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }

    /**
     * 返回俩个节点之间是否有边
     *
     * @param v 节点1索引位置
     * @param w 节点2索引位置
     * @return
     */
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v > n || w < 0 || w > n) {
            throw new RuntimeException("参数异常");
        }
        return g[v].contains(w);
    }

    /**
     * 返回节点相邻的所有节点
     *
     * @param v 节点索引位置
     * @return
     */
    public List<Integer> adj(int v) {
        return g[v];
    }
}
