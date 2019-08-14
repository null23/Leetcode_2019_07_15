package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * MidNum
 * 非递归的中序遍历
 */
public class _94 {
    /**
     * 中序遍历的非递归
     * 提示：用栈来维护，维护什么？维护前继节点的引用
     *
     * 时间复杂度：O(n)
     */
    public List<Integer> midOrder2(TreeNode root){
        List<Integer> res = new ArrayList<>();

        //放入栈中
        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();

        while(curNode != null || !stack.empty()){
            //左节点全部入栈
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.getLeft();
            }
            curNode = stack.pop();
            res.add(curNode.getVal());
            curNode = curNode.getRight();
        }
        return res;
    }
}
