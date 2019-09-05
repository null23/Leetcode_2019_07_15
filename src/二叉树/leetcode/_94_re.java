package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.Stack;

/**
 * 二叉树中序遍历（非递归）
 */
public class _94_re {
    public void midOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.empty()){
            while(root.left != null){
                stack.push(root);
                root = root.left;
            }
            System.out.println(stack.pop().val);
            root = root.right;
        }
    }
}
