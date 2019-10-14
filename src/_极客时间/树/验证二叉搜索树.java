package _极客时间.树;

import 二叉树.Tree.TreeNode;

public class 验证二叉搜索树 {

    /**
     * 中序遍历，保存上一节点的大小进行判断
     */
    private int last;
    public boolean isValidBST1(TreeNode root) {
        if(root == null){
            return true;
        }
        if(isValidBST1(root.getLeft())){
            if(last <= root.getVal()){
                last = root.getVal();
                return isValidBST1(root.getRight());
            }
        }
        return false;
    }

    /**
     * 递归，自底向上的递归
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        if(root.val < min.val || root.val > max.val){
            return false;
        }
        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}
