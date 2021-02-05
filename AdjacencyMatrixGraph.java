package org.hua.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class AdjacencyMatrixGraph implements Graph {

    private byte[][] adj;
    private int numEdges;

    public AdjacencyMatrixGraph(int numberOfVertices) {
        adj = new byte[numberOfVertices][numberOfVertices];
        numEdges = 0;
    }

    @Override
    public void addVertex(int v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeVertex(int v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addEdge(int v, int u) {
        checkVertex(v);
        checkVertex(u);
        if (adj[v][u] == 0) {
            adj[v][u] = 1;
            numEdges++;
        }
    }

    @Override
    public void removeEdge(int v, int u) {
        checkVertex(v);
        checkVertex(u);
        if (adj[v][u] != 0) {
            adj[v][u] = 0;
            numEdges++;
        }
    }

    @Override
    public int numVertices() {
        return adj.length;
    }

    @Override
    public int numEdges() {
        return numEdges;
    }

    @Override
    public Iterator<Integer> iterator() {
        return IntStream.range(0, adj.length).iterator();
    }

    @Override
    public boolean containsVertex(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertices are non-negative.");
        }
        return v >= 0 && v < adj.length;
    }

    @Override
    public boolean containsEdge(int v, int u) {
        checkVertex(v);
        checkVertex(u);
        return adj[v][u] != 0;
    }

    @Override
    public Iterator<Integer> outgoingIterator(int v) {
        checkVertex(v);
        return new OutIterator(v);
    }

    @Override
    public int outDegree(int v) {
        checkVertex(v);
        OutIterator it = new OutIterator(v);
        int count = 0;
        while (it.hasNext()) {
            count++;
            it.next();
        }
        return count;
    }

    private void checkVertex(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertices are non-negative.");
        }
        if (v >= adj.length) {
            throw new IllegalArgumentException("No vertex " + v);
        }
    }

    private class OutIterator implements Iterator<Integer> {

        private int cur;
        private int v;

        public OutIterator(int v) {
            this.v = v;
            this.cur = 0;
        }

        @Override
        public boolean hasNext() {
            while (cur < adj.length && adj[v][cur] == 0) {
                cur++;
            }
            return cur < adj.length;
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
