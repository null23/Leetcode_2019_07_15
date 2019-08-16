package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * MidNum
 * 寻找完全二叉树的叶子节点
 *
 * 给你一棵完全二叉树，请按以下要求的顺序收集它的全部节点：
 * 依次从左到右，每次收集并删除所有的叶子节点
 * 重复如上过程直到整棵树为空
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 输出: [[4,5,3],[2],[1]]
 */
public class _366 {

    /**
     * 思路：迭代 + 递归
     * 自顶向下的递归，分别递归左右子树，根据左右子树递归的结果来进行操作，和285题差不多
     *
     * 分别递归左右子树，分别找到左右子树的所有叶子节点放入数组，并且切断引用。
     * 递归的结束条件，就是当前节点是叶子节点。
     * 递归的返回结果，就是当前节点是不是叶子节点。
     *
     * 如何判断是叶子节点？ 叶子节点的判断条件就是左右子树均为空
     *
     * 利用 迭代 + 递归，每次迭代都找出一层叶子节点，迭代的结束条件就是 当前只剩一个根节点
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        while(root.left != null || root.right != null){
            List res = new ArrayList();
            helper(root, res);
            list.add(res);
        }
        List<Integer> rootList = new ArrayList();
        rootList.add(root.val);
        list.add(rootList);
        return list;
    }

    public boolean helper(TreeNode root, List<Integer> list){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        boolean leftLeaf = helper(root.left, list);
        boolean rightLeaf = helper(root.right, list);

        if(leftLeaf){
            list.add(root.left.val);
            root.left = null;
        }
        if(rightLeaf){
            list.add(root.right.val);
            root.right = null;
        }
        return false;
    }
}
