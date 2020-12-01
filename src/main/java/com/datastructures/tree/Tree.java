package com.datastructures.tree;

import java.util.Collection;

public interface Tree<T> {
    Collection<T> values();

    Collection<T> values(TRAVERSAL traversal);

    void insert(T data);

    T find(T data);

    boolean exists(T data);

    void delete(T data, SUCCESSOR successor);

    void delete(T data);

    long length();

    T getMax();

    T getMin();
}
