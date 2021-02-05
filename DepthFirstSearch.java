/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.graph;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author thanos
 */
public class DepthFirstSearch extends GraphSearch {
    
    public DepthFirstSearch(Graph graph, int source) {
        super(graph, source);
    }
    
    @Override
    public void run() {
        if(predecessors != null) {
            return;
        }
        
        predecessors = new HashMap<>();
        dfs(source, null);
    }
    
    private void dfs(int u, Integer from) {
        predecessors.put(u, from);
        
        Iterator<Integer> outgoingIterator = graph.outgoingIterator(u);
        while(outgoingIterator.hasNext()) {
            int v = outgoingIterator.next();
            
            if(!predecessors.containsKey(v)) {
                dfs(v, u);
            }
        }
    }
}
