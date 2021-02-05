/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.bst;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.hua.bst.BinarySearchTree;
import org.hua.bst.Dictionary;
import org.junit.Test;

public class BinarySearchTreeTest {

	private static final int SIZE = 10000;

	@Test
	public void testBinarySearchTree() {

		Dictionary<Integer, Integer> tree = new BinarySearchTree<>();

		Random rng = new Random(17);
		for (int i = 0; i < SIZE; i++) {
			int n = rng.nextInt(1000);
			tree.put(n, i);
		}

		Integer prev = null;
		for (int x : tree) {
			if (prev != null) {
				assertTrue(prev < x);
			}
			prev = x;
		}

	}

}
