/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.queue;
/**
 * A FIFO queue
 */

/**
 *
 * @author Rafail Ntymenos
 */
public interface Queue<E> {
    
    void push(E elem);
    
    E pop();
    
    E first();
    
    boolean isEmpty();
    
    int size();
    
    void clear();
}
