package 二叉树.Tree;

/**
 * Created by qianji.wang on 2019/7/22.
 * 深度优先遍历：前序遍历(根左右)，中序遍历(左根右)，后序遍历(左右根)
 * 注意，输出打印的其实都是根节点
 * 因为在递归到底的情况下，递归到底节点肯定是个叶子节点，是没有左右孩子的，其实这个叶子节点就是"根节点"
 */
public class BST_Order {
    private Node root;

    /**
     * 前序遍历 根 左 右
     */
    public void preOrder(Node root){
        if(root != null){
            System.out.println(root.getValue());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 中序遍历 左 根 右
     */
    public void inOrder(Node root){
        if(root != null){
            preOrder(root.getLeft());
            System.out.println(root.getValue());
            preOrder(root.getRight());
        }
    }

    /**
     * 后序遍历 左 右 根
     */
    public void postOrder(Node root){
        if(root != null){
            preOrder(root.getLeft());
            preOrder(root.getRight());
            System.out.println(root.getValue());
        }
    }
}
