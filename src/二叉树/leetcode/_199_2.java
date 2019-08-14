package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * MidNum
 * 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class _199_2 {

    int maxDepth = Integer.MAX_VALUE;

    /**
     * 思路：迭代
     *  优先遍历右子树，并且在遍历右子树的时候更新最大深度，这样可以在遍历相同高度的左子树的时候，根据最大深度判断已经遍历过相同高度的右子树，但前节点就不用加入结果集了
     *  然后在遍历左子树
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        helper(root, list, 0);
        return list;
    }

    public void helper(TreeNode root, List<Integer> res, int depth){
        if(root == null){
            return;
        }
        //主要限制了根节点的左子树和根节点的右子树同时遍历时，由于先遍历的右子树，maxDepth早就被遍历右子树时更新，左子树就不会加入结果集
        if(maxDepth < depth + 1){
            res.add(root.val);
            maxDepth = depth + 1;
        }
        helper(root.right, res, depth + 1);
        helper(root.left, res, depth + 1);
    }
}
