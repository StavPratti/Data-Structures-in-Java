/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.graph;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testAdjacencyList() {

		Graph g = new AdjacencyListGraph();

		for (int i = 0; i < 20; i += 2) {
			g.addVertex(i);
		}

		assertTrue(g.numVertices() == 10);

		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				assertTrue(g.containsVertex(i));
			} else {
				assertFalse(g.containsVertex(i));
			}
		}

		Set<Integer> vertices = new HashSet<>();
		for (Integer v : g) {
			vertices.add(v);
		}
		assertTrue(vertices.size() == 10);
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				assertTrue(vertices.contains(i));
			} else {
				assertFalse(vertices.contains(i));
			}
		}

		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(0, 6);
		assertTrue(g.outDegree(0) == 3);

		assertTrue(g.outDegree(2) == 0);

		g.addEdge(4, 6);
		g.addEdge(4, 8);

		assertTrue(g.outDegree(4) == 2);

		assertTrue(g.numEdges() == 5);

		g.removeVertex(0);
		assertFalse(g.containsVertex(0));

		assertTrue(g.numEdges() == 2);

		Set<Integer> out4Vertices = new HashSet<>();
		Iterator<Integer> out4It = g.outgoingIterator(4);
		while (out4It.hasNext()) {
			out4Vertices.add(out4It.next());
		}
		assertTrue(out4Vertices.size() == 2);
		assertTrue(out4Vertices.contains(6));
		assertTrue(out4Vertices.contains(8));
	}

	@Test
	public void testAdjacencyMatrix() {

		Graph g = new AdjacencyMatrixGraph(20);

		assertTrue(g.numVertices() == 20);

		for (int i = 0; i < 20; i++) {
			assertTrue(g.containsVertex(i));
		}
		assertFalse(g.containsVertex(21));

		Set<Integer> vertices = new HashSet<>();
		for (Integer v : g) {
			vertices.add(v);
		}
		assertTrue(vertices.size() == 20);
		for (int i = 0; i < 20; i++) {
			assertTrue(vertices.contains(i));
		}

		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(0, 6);
		assertTrue(g.outDegree(0) == 3);

		assertTrue(g.outDegree(2) == 0);

		g.addEdge(4, 6);
		g.addEdge(4, 8);

		assertTrue(g.outDegree(4) == 2);

		assertTrue(g.numEdges() == 5);

		Set<Integer> out4Vertices = new HashSet<>();
		Iterator<Integer> out4It = g.outgoingIterator(4);
		while (out4It.hasNext()) {
			out4Vertices.add(out4It.next());
		}
		assertTrue(out4Vertices.size() == 2);
		assertTrue(out4Vertices.contains(6));
		assertTrue(out4Vertices.contains(8));
	}

}
