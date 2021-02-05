/*
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.labs;

import java.util.Random;

public class Sorting {

	// ********** bubble sort **********
	
	public static void bubbleSort(int[] a, int n) {
		
		throw new UnsupportedOperationException();
		
	}

	// ********** insertion sort **********
	
	public static void insertionSort(int[] a, int n) {
		insertionSort(a, 0, n-1);
	}
	
	private static void insertionSort(int[] a, int l, int r) {
		throw new UnsupportedOperationException();
	}
	
	// ********** selection sort **********

	public static void selectionSort(int[] a, int n) {
		
		throw new UnsupportedOperationException();

	}

	// ********** merge sort **********
	
	private static boolean less(int a, int b) {
		return a < b;
	}

	private static void merge(int[] a, int l, int m, int r, int[] aux) {

		throw new UnsupportedOperationException();
	
	}

	private static void mergeSort(int[] a, int l, int r, int[] aux) {
		
		throw new UnsupportedOperationException();

	}

	public static void mergeSort(int[] a, int n) {
		if (n < 1) {
			throw new IllegalArgumentException("Cannot sort array of non-positive size!\n");
		}

		int[] aux = new int[n];
		mergeSort(a, 0, n - 1, aux);
	}
	
	// ********** quick sort **********

	private static int partition(int[] a, int l, int r) {
		
		throw new UnsupportedOperationException();

	}

	private static void quickSort(int[] a, int l, int r, Random rng) {
		
		throw new UnsupportedOperationException();

	}

	private static int randomPivot(int a[], int l, int r, Random rng) {
		
		throw new UnsupportedOperationException();
		
	}

	public static void quickSort(int[] a, int n, Random rng) {
		quickSort(a, 0, n - 1, rng);
	}

	public static void quickSort(int[] a, int n) {
		quickSort(a, n, new Random());
	}

}
