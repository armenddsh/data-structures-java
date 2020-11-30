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
        final Collection<Integer> collection = tree.traversal();

        assertArrayEquals(new Integer[]{-21233482, -111113, -113, -33, -13, -11, -3, -2, 3, 213, 23482, 333333},
                collection.toArray());
    }

    @Test
    public void preOrderTraversal_defaul() {
        final Collection<Integer> collection = tree.traversal(TRAVERSAL.IN_ORDER);

        assertArrayEquals(new Integer[]{-21233482, -111113, -113, -33, -13, -11, -3, -2, 3, 213, 23482, 333333},
                collection.toArray());
    }

    @Test
    public void preOrderTraversal_preOrder() {
        final Collection<Integer> collection = tree.traversal(TRAVERSAL.PRE_ORDER);

        assertArrayEquals(new Integer[]{-11, -21233482, -111113, -113, -33, -13, -3, -2, 3, 213, 23482, 333333},
                collection.toArray());
    }

    @Test
    public void afterOrderTraversal_postOrder() {
        final Collection<Integer> collection = tree.traversal(TRAVERSAL.POST_ORDER);

        assertArrayEquals(new Integer[]{-21233482, -111113, -113, -33, -13, -3, -2, 3, 213, 23482, 333333, -11},
                collection.toArray());
    }

    @Test
    public void delete() {
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
}
