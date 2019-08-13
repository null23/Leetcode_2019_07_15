package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class _112 {

    /**
     * 思路：注意这里是到叶子节点是否满足路径总和，直接遍历整棵树就好了，在下次递归的时候，都用目标值减去当前递归的节点的值
     *
     * 时间复杂度：O(n)  因为是遍历了整棵树
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.getVal() == sum && root.getLeft() == null && root.getRight() == null){
            return true;
        }
        return hasPathSum(root.getLeft(), sum - root.getVal()) || hasPathSum(root.getRight(), sum - root.getVal());
    }
}
