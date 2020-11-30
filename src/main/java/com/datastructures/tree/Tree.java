package com.datastructures.tree;

import java.util.Collection;

public interface Tree<T> {
    Collection<T> traversal();

    Collection<T> traversal(TRAVERSAL traversal);

    void insert(T data);

    T find(T data);

    boolean exists(T data);

    void delete(T data);

    long length();

    T getMax();

    T getMin();
}
