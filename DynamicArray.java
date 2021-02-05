/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.darray;

/**
 * A dynamic array implementation
 *
 * @param <E> the element type
 */
public class DynamicArray<E> implements DArray<E> {

    public static final int INITIAL_CAPACITY = 64;

    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        this.size = 0;
        this.array = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    @Override
    public void put(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        array[index] = value;
    }

    @Override
    public void add(E value) {
        if (size >= array.length) {
            doubleCapacity();
        }

        array[size++] = value;
    }

    @Override
    public void addAt(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size >= array.length) {
            doubleCapacity();
        }

        for (int j = size; j > index; j--) {
            array[j] = array[j - 1];
        }

        array[index] = value;
        size++;

    }

    @Override
    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        E ret = array[index];
        
        for(int j = index+1; j < size; j++) {
            array[j-1] = array[j];
        }
        size--;
        
        /*
         *gia na einai o pinakas gematos mono sto 1/2 tou synexeia.
         *Opote na mhn kanw snexeia doubleCapacity kai halfCapacity!
         */
        if(4 * size < array.length) {
            halfCapacity();
        }
        
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.array = (E[]) new Object[INITIAL_CAPACITY];
    }

    private void doubleCapacity() {
        int newCapacity = 2 * array.length;
        E[] newArray = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    private void halfCapacity() {
        if(array.length <= INITIAL_CAPACITY) {
            return;
        }
        
        int newCapacity = array.length / 2;
        E[] newArray = (E[]) new Object[newCapacity];
        
        for (int i = 0; i < Math.min(size, newCapacity); i++) {
            newArray[i] = array[i];
        }
        
        array = newArray;
        size = Math.min(size, newCapacity);
    }

}
