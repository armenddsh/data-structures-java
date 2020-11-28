package com.datastructures.tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    public BinarySearchTree(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is required");
        }

        root = new Node<T>(value);
    }

    public void insert(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Value is required");
        }
        final Node<T> newNode = new Node<T>(data);
        if (root == null) {
            root = newNode;
        }

        insertData(newNode, root);
    }

    private void insertData(Node<T> newNode, Node<T> current) {
        if (newNode.getData().compareTo(current.getData()) < 0) {
            if (current.getLeftChild() == null) {
                current.setLeftChild(newNode);
            } else {
                insertData(newNode, current.getLeftChild());
            }
        } else {
            if (current.getRightChild() == null) {
                current.setRightChild(newNode);
            } else {
                insertData(newNode, current.getRightChild());
            }
        }
    }

    public void traversal() {

    }

    public void delete(T data) {

    }

    public T getMax() {
        Node<T> current = root;
        T data = null;
        while (current != null) {
            if (current.getRightChild() == null) {
                data = current.getData();
                break;
            }
            current = current.getRightChild();
        }

        return data;
    }

    public T getMin() {
        Node<T> current = root;
        T data = null;
        while (current != null) {
            if (current.getLeftChild() == null) {
                data = current.getData();
                break;
            }
            current = current.getLeftChild();
        }

        return data;
    }
}
