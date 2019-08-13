package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * MinNum
 * 求为指定和的二叉树路径（到叶子节点）
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class _113 {

    /**
     * 思路：先序遍历 + 回溯法
     * 时间复杂度：O(n)
     *
     * 回溯法：https://segmentfault.com/a/1190000018319044?utm_source=tag-newest
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), list);
        return list;
    }

    public void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res){
        if(root == null){
            return;
        }
        path.add(root.getVal());

        if(root.getLeft() == null && root.getRight() == null){
            if(root.getVal() == sum){
                res.add(new ArrayList<>(path));
            }
        }else{
            helper(root.getLeft(), sum - root.getVal(), path, res);
            helper(root.getRight(), sum - root.getVal(), path, res);
        }

        //回溯，因为Java是引用传递，不能让path当前的最后一个节点影响对以后的递归的结果造成影响
        path.remove(path.size() - 1);
    }
}
