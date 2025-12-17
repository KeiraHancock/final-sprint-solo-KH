package com.example.bstapp;

import com.example.bstapp.service.BstService;
import com.example.bstapp.service.TreeDtos.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTests {

    @Test
    void bstSequential_rootCorrect() {
        BstService s = new BstService();
        TreeNode root = s.buildSequential(List.of(2, 1, 4, 3, 5));
        assertEquals(2, root.getValue());
    }

    @Test
    void bstSequential_leftChildCorrect() {
        BstService s = new BstService();
        TreeNode root = s.buildSequential(List.of(2, 1));
        assertNotNull(root.getLeft());
        assertEquals(1, root.getLeft().getValue());
    }

    @Test
    void bstSequential_rightChildCorrect() {
        BstService s = new BstService();
        TreeNode root = s.buildSequential(List.of(2, 3));
        assertNotNull(root.getRight());
        assertEquals(3, root.getRight().getValue());
    }
}
