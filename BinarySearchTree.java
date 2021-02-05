/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */

package org.hua.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {

    private Node<K, V> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public V put(K key, V value) {

        Node<K, V> cur = root, prev = null;
        
        int c = -1;
        while (cur != null) {
            c = key.compareTo(cur.key);
            if (c == 0) {
                V oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }

            prev = cur;

            if (c < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        
        // hang new node
        Node<K,V> n = new Node<>(key, value);
        if(prev == null) {
            root = n;
        } else {
            if(c < 0) {
                prev.left = n;
            } else {
                prev.right = n;
            }
        }
        
        size++;
        return null;
    }

    @Override
    public V remove(K key) {
        
        Node<K,V> p, pp;
        int c;
        
        p = root;  //old cur
        pp = null; //old prev
        
        while(p != null && (c = key.compareTo(p.key)) != 0) {
            pp = p;
            p = c < 0 ? p.left : p.right;
        }
        
        if(p == null) {
            //not found
            return null;
        }
        
        V ret = p.value;
        if(p.left != null && p.right != null) {
            //TODO: reduce to zero or one child case
            Node<K,V> s = p.left, ps = p;
            while(s.right != null) {
                ps = p;
                s = s.right;
            }
            p.key = s.key;
            p.value = s.value;
            p = s;
            pp = ps;
        }
        
        //now p has at most one child
        Node<K,V> pChild = p.left != null ? p.left : p.right;
        if(p == root) {
            root = pChild;
        } else {
            if(p == pp.left) {
                pp.left = pChild;
            } else {
                pp.right = pChild;
            }
        }
        
        size--;
        
        return ret;
    }

    @Override
    public V get(K key) {
        Node<K, V> tmp = searchRecursively(root, key);
        if (tmp == null) {
            return null;
        }
        return tmp.value;
    }

    @Override
    public boolean contains(K key) {
        return searchRecursively(root, key) != null;
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
        this.root = null;
        this.size = 0;

    }

    @Override
    public Iterator<K> iterator() {
        return new InorderIterator();
    }
    
    private class InorderIterator implements Iterator<K> {
        
        private Deque<Node<K,V>> deque;
        
        public InorderIterator() {
            deque = new ArrayDeque<>();
            pushAllLeft(root);
        }
        
        @Override
        public boolean hasNext() {
            return ! deque.isEmpty();
        }
        
        @Override
        public K next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<K,V> cur = deque.pop();
            
            if(cur.right != null) {
                pushAllLeft(cur.right);
            }
            
            return cur.key;
        }
        
        private void pushAllLeft(Node<K,V> x) {
            while(x != null) {
                deque.push(x);
                x = x.left;
            }
        }
        
    }

    private static class Node<K extends Comparable<K>, V> {

        public K key;
        public V value;
        public Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node<K, V> searchRecursively(Node<K, V> x, K key) {
        if (x == null) {
            return null;
        }

        int c = key.compareTo(x.key);
        if (c == 0) {
            return x;
        }
        if (c < 0) {
            if (x.left == null) {
                return null;
            }
            return searchRecursively(x.left, key);
        }
        if (x.right == null) {
            return null;
        }
        return searchRecursively(x.right, key);
    }

}
