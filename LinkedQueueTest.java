/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rafail Ntymenos
 */
public class LinkedQueueTest {
    
    public LinkedQueueTest() {
    }
    @Test
    public void testLinkedQueue() {
	Queue<Integer> q = new LinkedQueue<>();
		
	assertTrue(q.isEmpty());

	int count = 100000;

	for (int i = 0; i < count; i++) {
		q.push(i);
		assertTrue(q.size() == i + 1);
		assertTrue(q.first() == 0);
	}

	int current = 0;
	while (!q.isEmpty()) {
	    assertTrue(q.first() == current);
            assertTrue(q.pop() == current);
	    current++;
	}
	assertTrue(q.isEmpty());
    }

    
}
