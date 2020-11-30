package com.datastructures.tree;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void insert() {
        Assert.assertEquals(12, tree.length());
    }

    @Test
    public void find_value__should_exists() {
        final Integer integer = tree.find(3);

        Assert.assertNotNull(integer);
    }

    @Test
    public void find_value__should_not_exists() {
        final Integer integer = tree.find(1);

        Assert.assertNull(integer);
    }

    @Test
    public void exists__should_return_false() {
        final boolean integer = tree.exists(1);

        Assert.assertFalse(integer);
    }

    @Test
    public void exists__should_return_true() {
        final boolean integer = tree.exists(3);

        Assert.assertTrue(integer);
    }

    @Test
    public void traversal() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getMax() {
        final int max = tree.getMax();

        Assert.assertEquals(333333, max);
    }

    @Test
    public void getMin() {
        final int min = tree.getMin();

        Assert.assertEquals(-21233482, min);
    }
}
