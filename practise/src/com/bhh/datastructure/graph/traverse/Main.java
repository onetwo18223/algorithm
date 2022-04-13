package com.bhh.datastructure.graph.traverse;

import com.bhh.datastructure.graph.base.GraphUtil;
import com.bhh.datastructure.graph.base.SparseGraph;
import com.bhh.datastructure.graph.traverse.bfs.BFS;
import com.bhh.datastructure.graph.traverse.dfs.bobo.Components;
import com.bhh.datastructure.graph.traverse.dfs.DFS;
import com.bhh.datastructure.graph.traverse.dfs.Path;

/**
 * @author bhh
 * @description 测试DFS和BFS
 * @date Created in 2021-09-27 16:22
 * @modified By
 */
public class Main {
    public static void main(String[] args) {
        SparseGraph sparseGraph = GraphUtil.getSparseGraph();
        GraphUtil.outSparseGraph(sparseGraph);
        System.out.println(new DFS(sparseGraph).getCount());
        System.out.println(new DFS(sparseGraph).isConnect(0,3));

        System.out.println(new Components(sparseGraph).count());

        System.out.println(new Path(sparseGraph, 0).path(3));

        System.out.println(new BFS(sparseGraph, 0).shortPath(2));
    }
}
