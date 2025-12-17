package com.example.bstapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.bstapp.service.TreeDtos.TreeNode;

public class BstService {

    // REQUIRED: sequential insertion BST
    public TreeNode buildSequential(List<Integer> values) {
        TreeNode root = null;
        for (int v : values) {
            root = insert(root, v);
        }
        return root;
    }

    // BONUS: balanced BST from same numbers (sorted unique)
    public TreeNode buildBalanced(List<Integer> values) {
        List<Integer> sorted = new ArrayList<>(values);
        Collections.sort(sorted);

        // remove duplicates
        List<Integer> unique = new ArrayList<>();
        Integer prev = null;
        for (Integer v : sorted) {
            if (prev == null || !prev.equals(v)) unique.add(v);
            prev = v;
        }

        return buildBalancedRec(unique, 0, unique.size() - 1);
    }

    private TreeNode buildBalancedRec(List<Integer> sortedUnique, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;

        TreeNode node = new TreeNode(sortedUnique.get(mid));
        node.setLeft(buildBalancedRec(sortedUnique, lo, mid - 1));
        node.setRight(buildBalancedRec(sortedUnique, mid + 1, hi));
        return node;
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }
}
