/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.darray;

import static org.junit.Assert.assertTrue;

import org.hua.darray.DArray;
import org.hua.darray.DynamicArray;
import org.junit.Test;

public class DynamicArrayTest {

	private static final int SIZE = 10000;

	@Test
	public void testDynamicArray() {
		DArray<Integer> v = new DynamicArray<>();
		assertTrue(v.isEmpty());
		assertTrue(v.size() == 0);

		for (int i = 0; i < SIZE; i++) {
			v.add(i);
			assertTrue(v.size() == i + 1);
			assertTrue(!v.isEmpty());
		}

		assertTrue(v.size() == SIZE);

		for (int i = 0; i < SIZE; i++) {
			assertTrue(v.get(i) == i);
			v.put(i, i + 1);
			assertTrue(v.get(i) == i + 1);
		}

		for (int i = 0; i < SIZE; i++) {
			assertTrue(v.get(i) == i + 1);
		}

		v.addAt(0, 0);
		assertTrue(v.size() == SIZE + 1);

		for (int i = 0; i < SIZE + 1; i++) {
			assertTrue(v.get(i) == i);
		}

		int count = 0;
		while (!v.isEmpty()) {
			assertTrue(v.removeAt(0) == count);
			count++;
		}
		assertTrue(count == SIZE + 1);

		assertTrue(v.isEmpty());
		assertTrue(v.size() == 0);

		for (int i = 0; i < SIZE; i++) {
			v.add(i);
			assertTrue(v.size() == i + 1);
			assertTrue(!v.isEmpty());
		}
		v.clear();
		assertTrue(v.isEmpty());
		assertTrue(v.size() == 0);
	}

}
