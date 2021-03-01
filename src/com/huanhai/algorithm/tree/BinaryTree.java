package com.huanhai.algorithm.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树
 * <p>
 * 性质
 * 1）在二叉树的第i层上最多有2^i-1 个节点 。（i>=1）
 * 2）二叉树中如果深度为k,那么最多有2^k-1个节点。(k>=1）
 * 3）n0=n2+1 n0表示度数为0的节点数，n2表示度数为2的节点数。
 * 4）在完全二叉树中，具有n个节点的完全二叉树的深度为[log2n]+1，其中[log2n]是向下取整。
 * 5）若对含 n 个结点的完全二叉树从上到下且从左至右进行 1 至 n 的编号，
 * 则对完全二叉树中任意一个编号为 i 的结点有如下特性：
 * (1) 若 i=1，则该结点是二叉树的根，无双亲, 否则，编号为 [i/2] 的结点为其双亲结点;
 * (2) 若 2i>n，则该结点无左孩子， 否则，编号为 2i 的结点为其左孩子结点；
 * (3) 若 2i+1>n，则该结点无右孩子结点， 否则，编号为2i+1 的结点为其右孩子结点。
 * <p>
 * <p>
 * 满二叉树：在一棵二叉树中。如果所有分支结点都存在左子树和右子树，并且所有叶子都在同一层上，这样的二叉树称为满二叉树。
 * 满二叉树的特点有：
 * 1）叶子只能出现在最下一层。出现在其它层就不可能达成平衡。
 * 2）非叶子结点的度一定是2。
 * 3）在同样深度的二叉树中，满二叉树的结点个数最多，叶子数最多。
 * <p>
 * <p>
 * 完全二叉树：对一颗具有n个结点的二叉树按层编号，如果编号为i(1<=i<=n)的结点与同样深度的满
 * 二叉树中编号为i的结点在二叉树中位置完全相同，则这棵二叉树称为完全二叉树。
 *
 * @author 覃波
 * @version 1.0
 * @date 2021-01-08 15:16
 **/
public class BinaryTree {
    public static void main(String[] args) {
        int[] treeList = new int[]{1, 8, 2, -1, 9, 35, 7, -1, -1, 11, -1, 3, -1, -1, -1};
        TreeNode tree = createBinaryTree(treeList, 4);
        System.out.println("前序遍历---------------------");
        prelook(tree);
        System.out.println("\n中序遍历---------------------");
        midlook(tree);
        System.out.println("\n后序遍历---------------------");
        postlook(tree);
        System.out.println("\n层序遍历---------------------");
        levelOrder(tree);
        System.out.println("\n前序非递归遍历---------------------");
        preOrderLoop(tree);
        System.out.println("\n中序序非递归遍历---------------------");
        inOrderLoop(tree);

        String s = "{()(){}{}}({}){}";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                String tmp = stack.peek().toString() + s.charAt(i);
                if ("{}".equals(tmp) || "()".equals(tmp) || "[]".equals(tmp)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));

        }
        if (stack.isEmpty()) {
            System.out.println("括号合法");
        } else {
            System.out.println("括号不合法");
        }
    }

    /**
     * 创建二叉树
     *
     * @param treeList 节点顺序数组
     * @return 树或者null
     */
    public static TreeNode createBinaryTree(int[] treeList, int deep) {
        if (treeList == null) {
            return null;
        }
        TreeNode[] tree = new TreeNode[treeList.length];
        TreeNode root = new TreeNode(treeList[0]);
        tree[0] = root;
        //偏移量
        int offer;
        for (int i = 2; i <= deep; i++) {
            offer = (int) Math.pow(2, i - 1) - 1;
            for (int j = offer; j < (offer + (int) Math.pow(2, i - 1)); j++) {
                TreeNode prent = tree[(j - 1) / 2];
                TreeNode node = null;
                if (treeList[j] != -1) {
                    node = new TreeNode(treeList[j]);
                    tree[j] = node;

                }
                if (prent == null) {
                    continue;
                }
                if (j % 2 == 0) {
                    prent.setRight(node);
                } else {
                    prent.setLeft(node);
                }
            }
        }
        return root;
    }

    /**
     * 前序遍历，递归方式
     */
    public static void prelook(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(" " + tree.value);
        prelook(tree.getLeft());

        prelook(tree.getRight());

    }

    /**
     * 中序遍历，递归方式
     */
    public static void midlook(TreeNode tree) {
        if (tree == null) {
            return;
        }


        midlook(tree.getLeft());

        System.out.print(" " + tree.value);

        midlook(tree.getRight());


    }

    /**
     * 后序遍历，递归方式
     */
    public static void postlook(TreeNode tree) {
        if (tree == null) {
            return;
        }


        postlook(tree.getLeft());
        postlook(tree.getRight());
        System.out.print(" " + tree.value);

    }

    /**
     * 层序遍历，也称广度优先遍历
     * 利用队列进行遍历
     *
     * @param root 根节点
     */
    public static void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.pop();
            System.out.print(root.value + " ");
            if (root.getLeft() != null) queue.add(root.getLeft());
            if (root.getRight() != null) queue.add(root.getRight());
        }
    }

    /**
     * 前序遍历（非递归方式）
     */
    public static void preOrderLoop(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = tree;

        while (node != null || !stack.isEmpty()) {
            //迭代左孩子
            while (node != null) {
                System.out.print(node.getValue() + " ");
                stack.push(node);
                node = node.getLeft();
            }
            //出栈，压入右节点
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.getRight();
            }

        }
    }

    /**
     * 中序遍历（非递归方式）
     */
    public static void inOrderLoop(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = tree;

        while (node != null || !stack.isEmpty()) {
            //迭代左孩子
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            //出栈，压入右节点
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.getValue() + " ");
                node = node.getRight();
            }

        }
    }

    /**
     * 后序非递归遍历
     *
     * @param tree
     */
    public static void postOrderLoop(TreeNode tree) {

    }


    /**
     * 树节点
     */
    static class TreeNode {
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
    }
}


