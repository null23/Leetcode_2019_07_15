package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 *  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class _110_2 {
    /**
     * 递归
     * 自顶向下
     * 自顶向下和自顶向上的区别：
     *  自顶向下每次都求左右子树的最大高度，求最大高度就是一次递归，并且比较是否平衡又是一次递归，因此是两次递归
     *  而自顶向上，已经在判断的递归中递归到最下层的叶子节点，可以从下往上推导高度是否合法
     *
     *  自顶向下的时间复杂度：O(n * n)
     *  空间复杂度：O(n * n)
     */
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());

        if(Math.abs(left-right) > 1){
            return false;
        }
        return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    /**
     * 获取当前节点作为根节点的树的最大深度
     */
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
    }

}
