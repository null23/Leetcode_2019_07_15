package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * Easy
 * 给定一个二叉树，检查他是否是对称的
 */
public class _101 {
    public boolean isSymmetric(TreeNode root){
        return isSymmetric(root.getLeft(), root.getRight());
    }

    public boolean isSymmetric(TreeNode leftChild, TreeNode rightChild){
        if(leftChild == null && rightChild == null){
            return true;
        }else if(leftChild == null || rightChild == null){
            return false;
        }
        if(leftChild.getVal().equals(rightChild.getVal())){
            return isSymmetric(leftChild.getLeft(), rightChild.getRight()) &&
                    isSymmetric(leftChild.getRight(), rightChild.getLeft());
        }else{
            return false;
        }
    }
}
