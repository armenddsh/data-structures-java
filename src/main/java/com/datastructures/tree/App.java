package com.datastructures.tree;

public class App {
    public static void main(String[] args) {

        final Tree<Integer> tree = new BinarySearchTree<Integer>(1);
        tree.insert(2);
        tree.insert(31);
        tree.insert(-1);
        tree.insert(-2);
        tree.insert(-17);
        tree.insert(2);

        System.out.println("Max: " + tree.getMax());
        System.out.println("Min: " + tree.getMin());
    }
}

