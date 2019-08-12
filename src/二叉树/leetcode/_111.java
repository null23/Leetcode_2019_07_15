package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 二叉树的最小深度
 */
public class _111 {

    /**
     * 还是递归，自底向上的递归
     *
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if(root.getLeft() != null){
            minDepth = Math.min(minDepth(root.getLeft()), minDepth);
        }
        if(root.getLeft() != null){
            minDepth = Math.min(minDepth(root.getRight()), minDepth);
        }
        return minDepth + 1;
    }

}
