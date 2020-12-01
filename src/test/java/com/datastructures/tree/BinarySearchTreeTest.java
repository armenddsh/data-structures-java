package com.datastructures.tree;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private Tree<Integer> tree = null;

    @Before
    public void before() {
        tree = new BinarySearchTree<>();

        tree.insert(-11);
        tree.insert(-2);
        tree.insert(-3);
        tree.insert(-13);
        tree.insert(-113);
        tree.insert(-111113);
        tree.insert(3);
        tree.insert(-33);
        tree.insert(333333);
        tree.insert(213);
        tree.insert(23482);
        tree.insert(-21233482);
    }

    @After
    public void after() {
        tree = null;
    }

    @Test
    public void insert() {
        assertEquals(12, tree.length());
    }

    @Test
    public void find_value__should_exists() {
        final Integer integer = tree.find(3);

        assertNotNull(integer);
    }

    @Test
    public void find_value__should_not_exists() {
        final Integer integer = tree.find(1);

        assertNull(integer);
    }

    @Test
    public void exists__should_return_false() {
        final boolean integer = tree.exists(1);

        assertFalse(integer);
    }

    @Test
    public void exists__should_return_true() {
        final boolean integer = tree.exists(3);

        assertTrue(integer);
    }

    @Test
    public void inOrderTraversal() {
        final Collection<Integer> collection = tree.values();

        assertArrayEquals(new Integer[]{-21233482, -111113, -113, -33, -13, -11, -3, -2, 3, 213, 23482, 333333},
                collection.toArray());
    }

    @Test
    public void preOrderTraversal_defaul() {
        final Collection<Integer> collection = tree.values(TRAVERSAL.IN_ORDER);

        assertArrayEquals(new Integer[]{-21233482, -111113, -113, -33, -13, -11, -3, -2, 3, 213, 23482, 333333},
                collection.toArray());
    }

    @Test
    public void preOrderTraversal_preOrder() {
        final Collection<Integer> collection = tree.values(TRAVERSAL.PRE_ORDER);

        assertArrayEquals(new Integer[]{-11, -21233482, -111113, -113, -33, -13, -3, -2, 3, 213, 23482, 333333},
                collection.toArray());
    }

    @Test
    public void afterOrderTraversal_postOrder() {
        final Collection<Integer> collection = tree.values(TRAVERSAL.POST_ORDER);

        assertArrayEquals(new Integer[]{-21233482, -111113, -113, -33, -13, -3, -2, 3, 213, 23482, 333333, -11},
                collection.toArray());
    }

    @Test
    public void getMax() {
        final int max = tree.getMax();

        assertEquals(333333, max);
    }

    @Test
    public void getMin() {
        final int min = tree.getMin();

        assertEquals(-21233482, min);
    }

    /**
     * 10
     * /
     * 5
     * / \
     * 3  7
     */

    @Test
    public void deleteNodeTest0() {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(18);
        tree.insert(15);
        tree.insert(14);
        tree.insert(22);
        tree.insert(23);

        tree.delete(14);

        assertArrayEquals(new Integer[]{10, 15, 18, 22, 23},
                tree.values().toArray());
    }

    @Test
    public void deleteNodeTest1() {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(18);
        tree.insert(15);
        tree.insert(14);
        tree.insert(22);
        tree.insert(23);

        tree.delete(23);

        assertArrayEquals(new Integer[]{10, 14, 15, 18, 22},
                tree.values().toArray());
    }

    @Test
    public void deleteNodeTest2() {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(18);
        tree.insert(15);
        tree.insert(14);
        tree.insert(22);
        tree.insert(23);

        tree.delete(15);

        assertArrayEquals(new Integer[]{10, 14, 18, 22, 23},
                tree.values().toArray());
    }

    @Test
    public void deleteNodeTest3() {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(18);
        tree.insert(15);
        tree.insert(14);
        tree.insert(22);
        tree.insert(23);

        tree.delete(22);

        assertArrayEquals(new Integer[]{10, 14, 15, 18, 23},
                tree.values().toArray());
    }

    @Test
    public void deleteNodeTest4() {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(18);
        tree.insert(15);
        tree.insert(14);
        tree.insert(22);
        tree.insert(23);

        tree.delete(18);

        assertArrayEquals(new Integer[]{10, 14, 15, 22, 23},
                tree.values().toArray());
    }

    @Test
    public void deleteNodeTest5() {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(7);
        tree.insert(5);
        tree.insert(8);
        tree.insert(9);
        tree.insert(6);
        tree.insert(18);
        tree.insert(15);
        tree.insert(14);
        tree.insert(22);
        tree.insert(23);

        tree.delete(7);

        assertArrayEquals(new Integer[]{5, 6, 8, 9, 10, 14, 15, 18, 22, 23},
                tree.values().toArray());
    }
}
