/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.darray;

/**
 * A dynamic array
 *
 * @param <E> the element type
 */
public interface DArray<E> {

	/**
	 * Get the element at a position
	 * 
	 * @param index the index
	 * @return the element at index
	 */
	E get(int index);

	/**
	 * Set an element at a position
	 * 
	 * @param index the index
	 * @param value the value at that index
	 */
	void put(int index, E value);

	/**
	 * Add a value at the end of the array. Increases the capacity by one.
	 * 
	 * @param value the value
	 */
	void add(E value);

	/**
	 * Add an element at a position. Shifts all subsequent elements.
	 * 
	 * @param index the index
	 * @param value the value
	 */
	void addAt(int index, E value);

	/**
	 * Remove an element at a position
	 * 
	 * @param index the index
	 * @return the element
	 */
	E removeAt(int index);

	/**
	 * Check if empty
	 * 
	 * @return true if empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Get the size of the array.
	 * 
	 * @return the size of the array
	 */
	int size();

	/**
	 * Clear the array
	 */
	void clear();

}
