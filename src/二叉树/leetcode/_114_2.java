package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

public class _114_2 {

    /**
     * 用来维护 右 左 根 的右节点
     */
    TreeNode pre = null;

    /**
     * 递归的解法
     * 其实按照前序遍历的结果，就是链表从左到右的顺序，但是直接使用前序遍历并且修改当前节点的右孩子，是不行的
     * 所以就有另一个思路：自底向上，我们想要的结果，其实是 右 左 根 的递归
     * 参考：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
     */
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = pre;
        root.left = null;

        pre = root;
    }
}
