package 二叉树.Tree;

/**
 * Created by qianji.wang on 2019/7/22.
 */
public class TreeNode {
    public Integer val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer value) {
        this.val = value;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
