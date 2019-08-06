package 二叉树.Tree;

/**
 * Created by qianji.wang on 2019/7/22.
 */
public class Node {
    private Integer value;

    private Node left;

    private Node right;

    public Node() {
    }

    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
