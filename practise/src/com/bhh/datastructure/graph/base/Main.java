package com.bhh.datastructure.graph.base;

/**
 * @author bhh
 * @description 测试
 * @date Created in 2021-09-27 13:03
 * @modified By
 */
public class Main {
    static final int NUM = 10;

    public static void main(String[] args) {
        GraphUtil.outDenseGraph(GraphUtil.getDenseGraph());
        GraphUtil.outSparseGraph(GraphUtil.getSparseGraph());
    }
}
