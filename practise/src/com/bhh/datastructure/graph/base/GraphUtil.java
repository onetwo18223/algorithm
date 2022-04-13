package com.bhh.datastructure.graph.base;

/**
 * @author bhh
 * @description 图生成工具
 * @date Created in 2021-09-27 13:21
 * @modified By
 */
public class GraphUtil {
    final static int NUM = 7;

    /*
    0 6
    0 5
    0 4
    1 5
    1 2
    2 3
    2 5
    2 6
    4 6
    5 6
    6 6
     */
    final static int[][] nums = new int[][]{
            {0, 6}, {0, 5}, {0, 4}, {1, 5}, {1, 2}, {2, 3}, {2, 5}, {2, 6}
            , {4, 6}, {5, 6}, {6, 6}
    };

    /**
     * 根据指定二维数组生成邻接矩阵
     * @return
     */
    public static DenseGraph getDenseGraph() {
        DenseGraph graph = new DenseGraph(NUM, false);
        for (int[] num : nums) {
            graph.addEdge(num[0], num[1]);
        }
        return graph;
    }

    /**
     * 输出指定邻接矩阵
     * @param graph 邻接矩阵
     */
    public static void outDenseGraph(DenseGraph graph) {
        for (int i = 0; i < graph.V(); i++) {
            for (int j = 0; j < graph.V(); j++) {
                System.out.print("[" + i + "][" + j + "]:" + graph.getG()[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 根据指定二维数组生成邻接表
     * @return
     */
    public static SparseGraph getSparseGraph() {
        SparseGraph graph = new SparseGraph(NUM, false);
        for (int[] num : nums) {
            graph.addEdge(num[0], num[1]);
        }
        return graph;
    }

    /**
     * 输出指定邻接表
     * @param graph 邻接表
     */
    public static void outSparseGraph(SparseGraph graph){
        for (int i = 0; i < graph.V(); i++) {
            System.out.print(i + " : ");
            for (Integer integer : graph.adj(i)) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
