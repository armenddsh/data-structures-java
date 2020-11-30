package com.datastructures.tree;

public interface Tree<T> {
    void traversal();
    void insert(T data);
    T find(T data);
    boolean exists(T data);
    void delete(T data);
    long length();
    T getMax();
    T getMin();
}
