package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * MinNum
 * 二叉树的前序遍历（非递归）
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class _144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode curNode = stack.pop();
            list.add(curNode.val);
            if(curNode.right != null){
                stack.push(curNode.right);
            }
            if(curNode.left != null){
                stack.push(curNode.left);
            }
        }
        return list;
    }
}
