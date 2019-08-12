package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class _104 {

    /**
     * 递归
     * 空间复杂度的计算：
     *  空间复杂度就是递归栈的大小，也就是递归的次数
     *  这里递归的次数取决于树的高度，也就是logN
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftMax = maxDepth(root.getLeft());
        int rightMax = maxDepth(root.getRight());
        return Math.max(leftMax, rightMax) + 1;
    }
}
