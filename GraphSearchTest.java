/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.graph;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author thanos
 */
public class GraphSearchTest {

    @Test
    public void testBFS() {

        Graph g = new AdjacencyListGraph();

        for (int i = 0; i < 12; i++) {
            g.addVertex(i);
        }
        int[][] edges = {{0, 1}, {0, 2}, {0, 8}, {0, 9}, {1, 4}, {1, 3}, {2, 1}, {2, 5}, {2, 8},
        {3, 4}, {4, 7}, {5, 6}, {6, 7}, {7, 11}, {8, 10}, {9, 10}};

        for (int[] e : edges) {
            g.addEdge(e[0], e[1]);
        }

        assertEquals(g.numEdges(), edges.length);

        BreadthFirstSearch alg = new BreadthFirstSearch(g, 0);

        List<Integer> list = alg.getPathTo(11);
        System.out.println(list);

        assertEquals(alg.getPathTo(0), List.of(0));
        assertEquals(alg.getPathTo(6), List.of(0, 2, 5, 6));
        assertEquals(alg.getPathTo(7), List.of(0, 1, 4, 7));
        assertEquals(alg.getPathTo(10), List.of(0, 8, 10));
        assertEquals(alg.getPathTo(11), List.of(0, 1, 4, 7, 11));
    }

    @Test
    public void testDFS() {

        Graph g = new AdjacencyListGraph();

        for (int i = 0; i < 12; i++) {
            g.addVertex(i);
        }
        int[][] edges = {{0, 1}, {0, 2}, {0, 8}, {0, 9}, {1, 4}, {1, 3}, {2, 1}, {2, 5}, {2, 8},
        {3, 4}, {4, 7}, {5, 6}, {6, 7}, {7, 11}, {8, 10}, {9, 10}};

        for (int[] e : edges) {
            g.addEdge(e[0], e[1]);
        }

        assertEquals(g.numEdges(), edges.length);

        DepthFirstSearch alg = new DepthFirstSearch(g, 0);

        List<Integer> list = alg.getPathTo(11);
        System.out.println(list);

        assertEquals(alg.getPathTo(0), List.of(0));
        assertEquals(alg.getPathTo(6), List.of(0, 2, 5, 6));
        assertEquals(alg.getPathTo(7), List.of(0, 1, 4, 7));
        assertEquals(alg.getPathTo(10), List.of(0, 2, 8, 10));
        assertEquals(alg.getPathTo(11), List.of(0, 1, 4, 7, 11));
    }
}
