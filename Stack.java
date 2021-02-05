package org.hua.stack;

/**
 * A stack interface 
 * @author Rafail Ntymenos
 */
public interface Stack<E> {
    
    void push(E elem);
    
    E pop();
    
    E top();
    
    boolean isEmpty();
    
    int size();
    
    void clear();
}
