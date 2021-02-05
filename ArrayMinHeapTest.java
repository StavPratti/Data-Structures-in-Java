/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.hua.heap.ArrayMinHeap;
import org.hua.heap.MinHeap;
import org.junit.Test;

public class ArrayMinHeapTest {

	@Test
	public void testArrayMinHeap() {
		Random rng = new Random(17);

		MinHeap<Integer> h = new ArrayMinHeap<>();
		Integer currentMin = null;
		for (int i = 0; i < 10000; i++) {
			int key = rng.nextInt(500);
			if (currentMin == null || key < currentMin) {
				currentMin = key;
			}
			h.insert(key);
			assertTrue(h.size() == i + 1);
			assertEquals(h.findMin(), currentMin);
		}

		while (!h.isEmpty()) {
			h.deleteMin();
		}

		assertTrue(h.isEmpty());
	}

}
