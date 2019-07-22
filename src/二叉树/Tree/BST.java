package 二叉树.Tree;

/**
 * Created by qianji.wang on 2019/7/22.
 * 二叉查找树的插入
 */
public class BST {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node insert(Integer value){
        if(this.root == null){
            this.root = new Node(value);
            return this.root;
        }else{
            return insert(root, value);
        }
    }

    /**
     * 插入新的节点
     * 并且返回头节点
     * 注意这里返回的头节点，这里是递归查找新节点应该插入的位置
     */
    public Node insert(Node node, Integer value){
        if(node == null){
            return new Node(value);
        }
        if(node.getValue().equals(value)){
            node.setValue(value);
        }else if(node.getValue() < value){
            node.setLeft(insert(node.getLeft(), value));
        }else if(node.getValue() > value){
            node.setRight(insert(node.getLeft(), value));
        }
        return node;
    }

    public Node search(Integer value){
        return search(root, value);
    }

    /**
     * 查找一个节点
     */
    public Node search(Node node, Integer value){
        if(node.getValue().equals(value)){
            return node;
        }else if(node.getValue() < value){
            return search(node.getLeft(), value);
        }else {
            return search(node.getRight(), value);
        }
    }
}
