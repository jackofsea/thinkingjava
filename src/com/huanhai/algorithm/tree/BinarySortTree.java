package com.huanhai.algorithm.tree;

/**
 *
 * 二叉查找树（二叉排序树）
 *
 * @author 覃波
 * @version 1.0
 * @date 2021-01-15 15:42
 **/
public class BinarySortTree {


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
            if(value == o.value){
                return 0;
            }
            return value > o.value ? -1 :1;
        }
    }
}
