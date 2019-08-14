package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.*;

/**
 * MinNum
 * 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class _199 {

    /**
     * 迭代：维护两个队列，每次遍历一层，并且记录当前层的所有节点，取出最边缘的节点
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        list.add(root.val);

        while(true){
            Queue<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode curNode = q.poll();
                if(curNode.right != null){
                    temp.add(curNode.right);
                }
                if(curNode.left != null){
                    temp.add(curNode.left);
                }
            }
            if(temp.isEmpty()){
                break;
            }
            list.add(temp.peek().val);
            q.addAll(temp);
        }

        return list;
    }
}
