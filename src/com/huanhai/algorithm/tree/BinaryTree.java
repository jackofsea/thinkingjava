package com.huanhai.algorithm.tree;

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
        int[] treeList = new int[]{1, 2, 2, -1, 9, 35, 7};
        TreeNode tree = createBinaryTree(treeList, 3);
        System.out.println(tree);
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
            if ((int) Math.pow(2, i) - 1 <= treeList.length) {
                for (int j = offer; j < (offer + (int) Math.pow(2, i - 1)); j++) {
                    TreeNode prent = tree[(j - 1) / 2];
                    if (treeList[j] != -1) {
                        TreeNode node = new TreeNode(treeList[j]);
                        tree[j] = node;
                        if (j % 2 == 0) {
                            prent.setRight(node);
                        } else {
                            prent.setLeft(node);
                        }
                    } else {
                        if (j % 2 == 0) {
                            prent.setRight(null);
                        } else {
                            prent.setLeft(null);
                        }
                    }
                }
            }
        }
        return root;
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


