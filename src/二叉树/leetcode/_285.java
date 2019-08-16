package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * MidNum
 * 二叉搜索树中的顺序后继
 *
 * 给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
 * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
 */
public class _285 {

    public boolean find = false;

    public TreeNode res = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p);

        return res;
    }

    public void helper(TreeNode root, TreeNode p){
        if(root == null){
            return;
        }
        inorderSuccessor(root.left, p);
        if(!find && root.val > p.val){
            find = true;
            res = root;
        }
        inorderSuccessor(root.right, p);
    }
}
