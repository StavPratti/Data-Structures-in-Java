/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.graph;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author thanos
 */
public class BreadthFirstSearch extends GraphSearch {

    private Map<Integer, Integer> distances;

    public BreadthFirstSearch(Graph graph, int source) {
        super(graph, source);
    }

    public Map<Integer, Integer> getDistances() {
        run();
        return Collections.unmodifiableMap(distances);
    }

    @Override
    public void run() {
        if (predecessors != null) {
            // check if already existed
            return;
        }

        Queue<Integer> frontier = new ArrayDeque<>();
        distances = new HashMap<>();
        predecessors = new HashMap<>();

        frontier.add(source);
        predecessors.put(source, null);
        distances.put(source, 0);

        while (!frontier.isEmpty()) {
            int u = frontier.remove();

            Iterator<Integer> outgoingIterator = graph.outgoingIterator(u);
            while (outgoingIterator.hasNext()) {
                int v = outgoingIterator.next();

                if (!predecessors.containsKey(v)) {
                    predecessors.put(v, u);
                    distances.put(v, distances.get(u)+1);
                    frontier.add(v);
                }
            }
        }

    }
}
