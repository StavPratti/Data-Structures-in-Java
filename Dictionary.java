/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.bst;

import java.util.Iterator;

/**
 * A dictionary
 *
 * @param <E> the element type
 */
public interface Dictionary<K, V> extends Iterable<K> {

	/**
	 * Put a key value pair
	 * 
	 * @param key   a key
	 * @param value a value
	 * @return the previous value of the key already existed, else null 
	 */
	V put(K key, V value);

	/**
	 * Remove a mapping
	 * 
	 * @param key the key
	 * @return the value
	 */
	V remove(K key);

	/**
	 * Get the value associated with a key
	 * 
	 * @param key the key
	 * @return the value or null
	 */
	V get(K key);

	/**
	 * Check if a key exists
	 * 
	 * @param key the key
	 * @return true if it exists, false otherwise
	 */
	boolean contains(K key);

	/**
	 * Check if empty
	 * 
	 * @return true if empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Get the number of elements
	 * 
	 * @return the number of elements
	 */
	int size();

	/**
	 * Clear
	 */
	void clear();

	/**
	 * Get a key iterator.
	 * 
	 * @return a key iterator
	 */
	Iterator<K> iterator();
	
}
