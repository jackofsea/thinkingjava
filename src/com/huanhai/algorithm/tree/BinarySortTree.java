package com.huanhai.algorithm.tree;

/**
 * 二叉查找树（二叉排序树）
 *
 * 二叉排序树又称二叉排序树。它或者是一个空树，或者是一个具有下列性质的二叉树：
 *  1)若它的左子树不空，则左子树上所有节点的值均小于它的根结构的值；
 *  2)若它的右子树不空，则右子树上所有结点的值均大于它的根节点的值；
 *  3)它的左、右子树也分别是二叉排序树。
 *
 *
 *
 * @author 覃波
 * @version 1.0
 * @date 2021-01-15 15:42
 **/
public class BinarySortTree {
    public static void main(String[] args) {
        int[] val = new int[]{55, 23, 3, 23, 43, 45, 67, 23, 67};

    }

    TreeNode createBinarySortTree(int[] val) {
        if (val == null || val.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(val[0], null, null);
        return null;

    }


    /**
     * 树节点
     */
    static class TreeNode implements Comparable<TreeNode> {
        int value;
        BinaryTree.TreeNode left;
        BinaryTree.TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int value, BinaryTree.TreeNode left, BinaryTree.TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public BinaryTree.TreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTree.TreeNode left) {
            this.left = left;
        }

        public BinaryTree.TreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTree.TreeNode right) {
            this.right = right;
        }

        @Override
        public int compareTo(TreeNode o) {
            if (value == o.value) {
                return 0;
            }
            return value > o.value ? -1 : 1;
        }
    }
}
