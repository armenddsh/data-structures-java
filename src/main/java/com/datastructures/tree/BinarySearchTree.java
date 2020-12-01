package com.datastructures.tree;

import java.util.ArrayList;
import java.util.Collection;

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
            final Node<T> node = findNode(data, root);
            if (node != null) {
                return node.getData();
            }
        }

        return null;
    }

    @Override
    public boolean exists(T data) {
        return findNode(data, root) != null;
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
    public Collection<T> values() {
        final Collection<T> collection = new ArrayList<>((int) count);

        if (root != null)
            return inOrderTraversal(collection, root);

        return collection;
    }

    @Override
    public Collection<T> values(TRAVERSAL traversal) {
        final Collection<T> collection = new ArrayList<T>((int) count);

        if (root != null)
            switch (traversal) {
                case IN_ORDER:
                    return inOrderTraversal(collection, root);
                case PRE_ORDER:
                    return preOrderTraversal(collection, root);
                case POST_ORDER:
                    return postOrderTraversal(collection, root);
            }

        return collection;
    }

    private Collection<T> inOrderTraversal(Collection<T> collection, Node<T> root) {
        final Node<T> leftChild = root.getLeftChild();
        final Node<T> rightChild = root.getRightChild();

        if (leftChild != null) {
            inOrderTraversal(collection, leftChild);
        }

        collection.add(root.getData());

        if (rightChild != null) {
            inOrderTraversal(collection, rightChild);
        }

        return collection;
    }

    private Collection<T> preOrderTraversal(Collection<T> collection, Node<T> root) {
        final Node<T> leftChild = root.getLeftChild();
        final Node<T> rightChild = root.getRightChild();

        collection.add(root.getData());

        if (leftChild != null) {
            inOrderTraversal(collection, leftChild);
        }
        if (rightChild != null) {
            inOrderTraversal(collection, rightChild);
        }

        return collection;
    }

    private Collection<T> postOrderTraversal(Collection<T> collection, Node<T> root) {
        final Node<T> leftChild = root.getLeftChild();
        final Node<T> rightChild = root.getRightChild();

        if (leftChild != null) {
            inOrderTraversal(collection, leftChild);
        }

        if (rightChild != null) {
            inOrderTraversal(collection, rightChild);
        }

        collection.add(root.getData());

        return collection;
    }

    @Override
    public void delete(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is required!");
        }

        if (root != null) {
            deleteNode(data, root);
        }
    }

    private Node<T> deleteNode(T data, Node<T> node) {
        if (node == null) {
            return null;
        }

        final T nodeData = node.getData();

        if (data.compareTo(nodeData) < 0) {
            node.setLeftChild(deleteNode(data, node.getLeftChild()));
        } else if (data.compareTo(nodeData) > 0) {
            node.setRightChild(deleteNode(data, node.getRightChild()));
        } else {
            final Node<T> subChildLeft = node.getLeftChild();
            final Node<T> subChildRight = node.getRightChild();

            if (subChildLeft == null && subChildRight == null) {
                return null;
            } else if (subChildLeft != null && subChildRight == null) {
                node.setLeftChild(null);
                return subChildLeft;
            } else if (subChildRight != null && subChildLeft == null) {
                node.setRightChild(null);
                return subChildRight;
            } else {
                final Node<T> successor = findSuccessor(node.getLeftChild());
                node.setData(successor.getData());
                node.setLeftChild(deleteNode(successor.getData(), node.getLeftChild()));
            }
        }
        return node;
    }

    private Node<T> findSuccessor(Node<T> node) {
        if (node.getRightChild() == null) {
            return node;
        }
        return findSuccessor(node.getRightChild());
    }

    private Node<T> findPredecessor(Node<T> node) {
        if (node.getLeftChild() == null) {
            return node;
        }
        return findSuccessor(node.getLeftChild());
    }

    private Node<T> findNode(T data, Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() == null) {
                return null;
            } else {
                return findNode(data, node.getLeftChild());
            }
        } else if (data.compareTo(node.getData()) > 0) {
            if (node.getRightChild() == null) {
                return null;
            } else {
                return findNode(data, node.getRightChild());
            }
        } else {
            return node;
        }
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
