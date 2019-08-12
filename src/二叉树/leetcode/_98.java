package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * MidNum
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树
 */
public class _98 {

    /**
     * 解题思路：
     *  找到当前节点的左子树的最小值(理应是最左的叶子节点)，以及右子树的最大值（理应是最右的叶子节点），和当前节点的值进行比较
     *
     *  时间复杂度：O(n * n)
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, TreeNode min, TreeNode max){
        if(node == null){
            return true;
        }
        if(node.getVal() < min.getVal()){
            return false;
        }
        if(node.getVal() > max.getVal()){
            return false;
        }
        return isValidBST(node.getLeft(), min, node) &&
                isValidBST(node.getRight(), node, max);
    }
}
