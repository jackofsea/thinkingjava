package com.huanhai.algorithm.tree;

/**
 * 二叉查找树（二叉排序树）
 * <p>
 * 二叉排序树又称二叉排序树。它或者是一个空树，或者是一个具有下列性质的二叉树：
 * 1)若它的左子树不空，则左子树上所有节点的值均小于它的根结构的值；
 * 2)若它的右子树不空，则右子树上所有结点的值均大于它的根节点的值；
 * 3)它的左、右子树也分别是二叉排序树。
 *
 * @author 覃波
 * @version 1.0
 * @date 2021-01-15 15:42
 **/
public class BinarySortTree {
    public static void main(String[] args) {
        int[] val = new int[]{55, 23, 3, 24, 43, 45, 67, 24, 68};
        TreeNode binarySortTree = createBinarySortTree(val);
        removeNode(binarySortTree, 68);
    }

    /**
     * 构建二叉搜索树
     *
     * @param val 节点数组
     * @return 二叉搜索树
     */
    public static TreeNode createBinarySortTree(int[] val) {
        if (val == null || val.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(val[0], null, null);
        for (int i = 1; i < val.length; i++) {
            addNodeByIterator(root, new TreeNode(val[i], null, null));
        }
        return root;

    }

    /**
     * 添加树节点，递归
     *
     * @param root 根节点
     * @param node 新节点
     */
    public static void addNode(TreeNode root, TreeNode node) {
        if (root.getValue() > node.getValue()) {
            if (root.getLeft() != null) {
                addNode(root.getLeft(), node);
            } else {
                root.setLeft(node);
            }

        } else {
            if (root.getRight() != null) {
                addNode(root.getRight(), node);
            } else {
                root.setRight(node);
            }
        }
    }

    /**
     * 添加树节点，迭代
     *
     * @param root 根节点
     * @param node 新节点
     */
    public static void addNodeByIterator(TreeNode root, TreeNode node) {
        while (root != null) {
            if (root.getValue() > node.getValue()) {
                if (root.getLeft() != null) {
                    root = root.getLeft();
                    continue;
                }
                root.setLeft(node);
            } else {
                if (root.getRight() != null) {
                    root = root.getRight();
                    continue;
                }
                root.setRight(node);
            }
            break;
        }

    }

    /**
     * 删除节点
     *
     * @param root
     * @param node
     */
    public static void removeNode(TreeNode root, int node) {
        TreeNode perNode = null;
        while (root != null && root.getValue() != node) {
            perNode = root;
            if (  node < root.getValue()) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null) {
            System.out.println("没有找到对应的节点");
            return;
        }
        if (root.getRight() != null && root.getLeft() != null) {
            System.out.println("节点有左右节点");
        } else {
            assert perNode != null;
            perNode.setRight(null);
            perNode.setLeft(null);
        }

    }


    /**
     * 树节点
     */
    static class TreeNode implements Comparable<TreeNode> {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
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

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
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
