package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class _230 {

    int num = 1;

    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);

        return res;
    }

    public void helper(TreeNode root, int k){
        if(root == null){
            return;
        }
        helper(root.left, k);
        if(num++ == k){
            res = root.val;
        }
        helper(root.right, k);
    }
}
