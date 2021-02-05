/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.graph;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

	public static void main(String args[]) throws IOException {

		if (args.length < 1) {
			System.out.println("Usage: program filename");
			System.exit(-1);
		}

		final Pattern space = Pattern.compile("[ \\t\\x0B\\f\\r]+");

		Map<String, Integer> vertexMap = new HashMap<>();
		Map<Integer, String> inverseVertexMap = new HashMap<>();
		int nextVertex = 0;

		Graph graph = new AdjacencyListGraph();

		try (Scanner scanner = new Scanner(new File(args[0]))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.startsWith("#")) {
					// skip comments
					continue;
				}

				String[] endpoints = space.split(line);

				if (endpoints.length < 2) {
					throw new IllegalArgumentException("Invalid line: " + line);
				}

				// add endpoints if not present
				for (int i = 0; i < 2; i++) {
					if (!vertexMap.containsKey(endpoints[i])) {
						int vertex = nextVertex++;
						vertexMap.put(endpoints[i], vertex);
						inverseVertexMap.put(vertex, endpoints[i]);
					}
				}
				int source = vertexMap.get(endpoints[0]);
				int target = vertexMap.get(endpoints[1]);

				// add to graph
				graph.addVertex(source);
				graph.addVertex(target);
				graph.addEdge(source, target);
			}
		}
		
		System.out.println("Number of vertices: " + graph.numVertices());
		System.out.println("Number of edges: " + graph.numEdges());

	}

}
