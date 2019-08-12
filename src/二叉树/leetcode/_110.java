package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 *  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class _110 {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        getHigh(root);
        return res;
    }

    /**
     * 递归
     * 自底向上
     * 时间复杂度：O(n)
     */
    public int getHigh(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = getHigh(node.getLeft());
        int right = getHigh(node.getRight());

        if(Math.abs(left - right) > 1){
            res = false;
        }
        return Math.max(left, right);
    }
}
