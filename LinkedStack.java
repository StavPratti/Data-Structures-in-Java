/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.stack;

import java.util.NoSuchElementException;

/**
 *A stack using a Linked list reprasentation.
 * @author Rafail Ntymenos
 */
public class LinkedStack<E> implements Stack<E>{
    private int size;
    private Node<E> head;
    
    public LinkedStack(){
        this.size = 0;
        this.head = null;
    }
    
    @Override
    public void push(E elem) {
        Node<E> n = new Node<>();
        n.data = elem;
        n.next = head;
        head = n;
        size++;        
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new NoSuchElementException("Cannot pop from an empty stack");
        }
        E result = head.data;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public E top() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        return head.data;
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
        size = 0;
        head = null;
    }
    
    
    private static class Node<E>{
        public E data;
        public Node<E> next;
    }
}
