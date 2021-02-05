package org.hua.stack;

import java.util.NoSuchElementException;

/**
 * A stack implementation using an array
 * @author Rafail Ntymenos
 */
public class ArrayStack<E> implements Stack<E>{
    
    public static final int DEFAULT_CAPACITY = 64;
    
    private E[] array;
    private int top;
    
    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayStack(int capacity) {
        
        if(capacity <=0){
            throw new IllegalArgumentException("Wrong capacity");
        }
        
        this.array = (E[]) new Object[capacity];
        this.top = -1;
    }

    @Override
    public void push(E elem) {
        
        if(top >= array.length-1){
            doubleCapacity();
        }
        
        array[++top] = elem;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        
        E tmp = array[top];
        array[top] = null;
        top--;
        return tmp;
    }

    @Override
    public E top() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void clear() {
        for(int i = 0; i <= top;i++){
            array[i] = null;
        }
        top = -1;
    }
    
    private void doubleCapacity(){
        int newCapacity = 2 * array.length;
        E[] newArray = (E[]) new Object[newCapacity];
        
        for(int i = 0; i <- top;i++){
            newArray[i] = array[i];
        }
        
        array = newArray;
    }
    
}
