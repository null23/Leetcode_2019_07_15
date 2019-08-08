package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树
 */
public class _98_2 {
    //记录上一个合法的节点的值
    public static Integer last = Integer.MIN_VALUE;

    /**
     * 解析：
     *  这种解法，我理解和非递归中序遍历类似，那个是利用栈保存了上一层的引用，这个是用递归栈保存了上一层的引用
     *  递归自顶向上来比较左右孩子和父节点的大小，并且更新last为左子树最小值
     *  重点是last，last是左子树理应的最小值
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(isValidBST(root.getLeft())){
            if(last <= root.getVal()){
                last = root.getVal();
                return isValidBST(root.getRight());
            }
        }
        return false;
    }
}
