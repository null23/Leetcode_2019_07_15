package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 */
public class _100 {
    public boolean isSameTree(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(!node1.getVal().equals(node2.getVal())){
            return false;
        }
        return isSameTree(node1.getLeft(), node2.getLeft()) &&
                isSameTree(node1.getRight(), node2.getRight());
    }
}
