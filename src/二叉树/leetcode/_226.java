package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 翻转一棵二叉树
 */
public class _226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }


}
