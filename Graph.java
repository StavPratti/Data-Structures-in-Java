/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.graph;

import java.util.Iterator;

/**
 * A directed graph
 */
public interface Graph extends Iterable<Integer> {

	void addVertex(int v);

	void removeVertex(int v);

	boolean containsVertex(int v);
	
	void addEdge(int u, int v);

	void removeEdge(int u, int v);

	boolean containsEdge(int u, int v);

	int numVertices();

	int numEdges();

	Iterator<Integer> iterator();

	Iterator<Integer> outgoingIterator(int v);
	
	int outDegree(int v);

}
