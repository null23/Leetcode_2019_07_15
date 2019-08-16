package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class _230_2 {

    int num = 0;

    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.empty()){
            while(root != null){
                stack.push(root);
                if(num++ == k + 1){
                    res = root.val;
                }
                root = root.left;
            }
            stack.pop();
            root = root.right;
        }
        return res;
    }
}
