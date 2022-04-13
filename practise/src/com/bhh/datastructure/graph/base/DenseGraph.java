package com.bhh.datastructure.graph.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 邻接矩阵
 * @date Created in 2021-09-27 9:19
 * @modified By
 */
public class DenseGraph {
    // n为节点数量, m是边数
    private int n, m;
    // directed为是否是有向图
    private boolean directed;
    // 存储邻接矩阵
    private boolean[][] g;

    DenseGraph(int n, boolean directed) {
        this.n = n;
        // 初始化没有边
        this.m = 0;
        this.directed = directed;
        // 初始化矩阵, 默认全部位false
        g = new boolean[n][n];
    }

    /**
     * 获取节点数
     *
     * @return 节点数
     */
    public int V() {
        return n;
    }

    /**
     * 获取边数
     *
     * @return 边数
     */
    public int E() {
        return m;
    }

    /**
     * 获取数组
     * @return
     */
    public boolean[][] getG(){
        return g;
    }

    /**
     * 添加一个从v到w的边
     * 添加边是将 g[v][w](无向图包含g[w][v]) 设置为true
     *
     * @param v 节点1索引位置
     * @param w 节点2索引位置
     */
    public void addEdge(int v, int w) {
        if (hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;
        // 无向图
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    /**
     * 返回俩个节点之间是否有边
     * @param v 节点1索引位置
     * @param w 节点2索引位置
     * @return
     */
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v > n || w < 0 || w > n) {
            throw new RuntimeException("参数异常");
        }
        return g[v][w];
    }

    /**
     * 获取和节点v相邻的所有节点集合
     * @param v 节点1的索引位置
     * @return
     */
    public List<Integer> adj(int v){
        List<Integer> adjV = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]){
                adjV.add(i);
            }
        }
        return adjV;
    }
}
