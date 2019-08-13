package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 二叉树的最小深度（从根节点到叶子节点）
 */
public class _111 {

    /**
     * 还是递归，自底向上的递归
     * 时间复杂度：O(n)
     *
     * 思路：
     *  这道题有点坑，因为题目是求根节点到叶子节点的最小深度，所以之前的解法在出现(1,2)这样的测试用例就有问题。
     *  所以这道题分为很多种情况：
     *      1.当前节点为空，就返回0，这个没什么问题
     *      2.当前节点的左右孩子为空，说明到达了叶子节点，返回1
     *      3.当前节点的左孩子或右孩子有一个是空的，这时候就要避免上边提到的那个坑了，假如当前节点的左孩子是空的，那么我们就要返回（右孩子的高度 + 1），而不是返回（0 + 1）
     *      4.当前节点的左右孩子均不为空，那就返回左右孩子中高度最小的
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }
        int leftDepth = minDepth(root.getLeft());
        int rightDepth = minDepth(root.getRight());

        if(root.getLeft() == null || root.getRight() == null){
            return leftDepth + rightDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

}
