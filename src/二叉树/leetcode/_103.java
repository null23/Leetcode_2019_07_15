package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qianji.wang on 2019/8/9.
 * 二叉树的锯齿形层次遍历：
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class _103 {

    public static boolean fromLeft2Right = false;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack();
        stack.add(root);

        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.getVal());
                if(fromLeft2Right){
                    tempStack.push(node.getLeft());
                    tempStack.push(node.getRight());
                }else{
                    tempStack.push(node.getRight());
                    tempStack.push(node.getLeft());
                }
            }
            res.add(list);
            stack.addAll(tempStack);
        }

        return res;
    }

}
