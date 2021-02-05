package org.hua.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class AdjacencyListGraph implements Graph {

    private ArrayList<LinkedList<Integer>> adj;
    private int numVertices;
    private int numEdges;

    public AdjacencyListGraph() {
        adj = new ArrayList<>();
        numVertices = 0;
        numEdges = 0;
    }

    @Override
    public void addVertex(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertices are non-negative.");
        }
        if (v < adj.size()) {
            if (adj.get(v) == null) {
                adj.set(v, new LinkedList<>());
                numVertices++;
            }
        } else {
            while (v >= adj.size()) {
                adj.add(null);
            }
            adj.set(v, new LinkedList<>());
            numVertices++;
        }
    }

    @Override
    public void removeVertex(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertices are non-negative.");
        }
        if (v < adj.size()) {
            int edges = adj.get(v).size();
            adj.set(v, null);
            numVertices--;
            numEdges -= edges;
        }
    }

    @Override
    public void addEdge(int v, int u) {
        checkVertex(v);
        checkVertex(u);
        if (!adj.get(v).contains(Integer.valueOf(u))) {
            adj.get(v).add(u);
            numEdges++;
        }
    }

    @Override
    public void removeEdge(int v, int u) {
        checkVertex(v);
        checkVertex(u);
        ListIterator<Integer> it = adj.get(v).listIterator();
        while (it.hasNext()) {
            Integer t = it.next();
            if (t == u) {
                it.remove();
                numEdges--;
                return;
            }
        }
    }

    @Override
    public int numVertices() {
        return numVertices;
    }

    @Override
    public int numEdges() {
        return numEdges;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new VertexIterator();
    }

    @Override
    public boolean containsVertex(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertices are non-negative.");
        }
        return v >= 0 && v < adj.size() && adj.get(v) != null;
    }

    @Override
    public boolean containsEdge(int v, int u) {
        checkVertex(v);
        checkVertex(u);
        return adj.get(v).stream().anyMatch(x -> x.equals(u));
    }

    @Override
    public Iterator<Integer> outgoingIterator(int v) {
        checkVertex(v);
        return adj.get(v).iterator();
    }

    @Override
    public int outDegree(int v) {
        checkVertex(v);
        return adj.get(v).size();
    }

    private void checkVertex(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertices are non-negative.");
        }
        if (v >= adj.size() || adj.get(v) == null) {
            throw new IllegalArgumentException("No vertex " + v);
        }
    }

    private class VertexIterator implements Iterator<Integer> {

        private int cur;

        public VertexIterator() {
            cur = 0;
        }

        @Override
        public boolean hasNext() {
            while (cur < adj.size() && adj.get(cur) == null) {
                cur++;
            }
            return cur < adj.size();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return cur++;
        }

    }

}
