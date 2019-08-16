package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class _235 {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    public int helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return 0;
        }
        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);

        int mid = 0;
        if(root.val == p.val || root.val == q.val){
            mid = 1;
        }

        if(left + right + mid > 1){
            res = root;
        }

        return left + right + mid;
    }

}
