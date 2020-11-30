package com.datastructures.tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    private long count = 0;

    public BinarySearchTree() {
    }

    public BinarySearchTree(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is required");
        }

        root = new Node<T>(value);
        incrementCount();
    }

    private void incrementCount() {
        count++;
    }

    @Override
    public void insert(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Value is required");
        }
        final Node<T> newNode = new Node<T>(data);
        if (root == null) {
            root = newNode;
            incrementCount();
            return;
        }

        insertData(newNode, root);
    }

    @Override
    public T find(T data) {
        if (root != null) {
            return findNode(data, root);
        }

        return null;
    }

    @Override
    public boolean exists(T data) {
        return findNode(data, root) != null;
    }

    private T findNode(T data, Node<T> root) {
        if (data.compareTo(root.getData()) < 0) {
            if (root.getLeftChild() == null) {
                return null;
            } else {
                return findNode(data, root.getLeftChild());
            }
        } else if (data.compareTo(root.getData()) > 0) {
            if (root.getRightChild() == null) {
                return null;
            } else {
                return findNode(data, root.getRightChild());
            }
        } else {
            return data;
        }
    }

    private void insertData(Node<T> newNode, Node<T> current) {
        if (newNode.getData().compareTo(current.getData()) < 0) {
            if (current.getLeftChild() == null) {
                current.setLeftChild(newNode);
                incrementCount();
            } else {
                insertData(newNode, current.getLeftChild());
            }
        } else {
            if (current.getRightChild() == null) {
                current.setRightChild(newNode);
                incrementCount();
            } else {
                insertData(newNode, current.getRightChild());
            }
        }
    }

    @Override
    public void traversal() {

    }

    @Override
    public void delete(T data) {

    }

    @Override
    public long length() {
        return count;
    }

    @Override
    public T getMax() {
        if (root != null) {
            return getMaxValue(root);
        }
        return null;
    }

    @Override
    public T getMin() {
        if (root != null) {
            return getMinValue(root);
        }
        return null;
    }

    private T getMinValue(Node<T> node) {
        final Node<T> leftChild = node.getLeftChild();
        if (leftChild != null) {
            return getMinValue(leftChild);
        }
        return node.getData();
    }

    private T getMaxValue(Node<T> node) {
        final Node<T> rightChild = node.getRightChild();
        if (rightChild != null) {
            return getMaxValue(rightChild);
        }
        return node.getData();
    }
}
