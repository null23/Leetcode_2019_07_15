package 二叉树.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qianji.wang on 2019/7/22.
 * 深度优先遍历：前序遍历(根左右)，中序遍历(左根右)，后序遍历(左右根)
 * 注意，输出打印的其实都是根节点
 * 因为在递归到底的情况下，递归到底节点肯定是个叶子节点，是没有左右孩子的，其实这个叶子节点就是"根节点"
 *
 * 广度优先遍历：层序遍历
 * 这里使用队列记录上一层的所有节点，依此把上一层节点的所有记录打印出来
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
            inOrder(root.getLeft());
            System.out.println(root.getValue());
            inOrder(root.getRight());
        }
    }

    /**
     * 后序遍历 左 右 根
     */
    public void postOrder(Node root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getValue());
        }
    }

    /**
     * 层序遍历
     * 主要是用一个队列维护上下的层级关系
     * 把上一层打印出来并弹出，然后把上一层的所有左右孩子分别加入队列，再依此把左右孩子的左右孩子放入对垒
     */
    public void levelSort(Node root){
        Queue<Node> queue = new LinkedList();
        //入队
        queue.offer(root);
        //队列不为空，继续
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            System.out.println(curNode);
            //把左孩子加入队列尾部
            if(curNode.getLeft() != null){
                queue.offer(curNode.getLeft());
            }
            //把右孩子加入队列尾部
            if(curNode.getRight() != null){
                queue.offer(curNode.getRight());
            }
        }
    }
}
