/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author thanos
 */
public abstract class GraphSearch {
    
    protected Graph graph;
    protected int source;
    protected Map<Integer, Integer> predecessors;
    
    public GraphSearch(Graph graph, int source) {
        this.graph = Objects.requireNonNull(graph);
        this.source = source;
        
        if(!graph.containsVertex(source)) {
            throw new IllegalArgumentException("Source vertex is not in the graph");
        }
    }
    
    public abstract void run();
    
    public Map<Integer, Integer> getPredecessors() {
        run();
        return Collections.unmodifiableMap(predecessors);
    }
    
    /**
     * Returns the path from path to target.
     * 
     * @param target the target vertex
     * @return the source from path to target, null if no path exists
     */
    public List<Integer> getPathTo(int target) {
        if(!graph.containsVertex(target)) {
            throw new IllegalArgumentException();
        }
        if(target == source) {
            //List.of(source)
            List<Integer> res = new ArrayList<>();
            res.add(source);
            return res;
        }
        
        run();
        
        if(!predecessors.containsKey(target)) {
            //no path
            return null;
        }
        
        List<Integer> path = new ArrayList<>();
        path.add(target);
        
        Integer cur = predecessors.get(target);
        while(cur != null) {
            path.add(cur);
            cur = predecessors.get(cur);
        }
        
        Collections.reverse(path);
        return path;
    }
}
