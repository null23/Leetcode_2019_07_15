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

    /**
     * 查找最小节点
     */
    public Node findMin(Node node){
        if(node.getLeft() == null){
            return node;
        }else{
            return findMin(node.getLeft());
        }
    }

    /**
     * 删除最小节点
     */
    public Node deleteMin(Node node){
        if(node.getLeft() == null){
            node = null;
        }
        return deleteMin(node.getLeft());
    }

    /**
     * 查找最大节点
     */
    public Node findMax(Node node){
        if(node.getRight() == null){
            return node;
        }else{
            return findMax(node.getRight());
        }
    }

    /**
     * 删除最大节点
     */
    public Node deleteMax(Node node){
        if(node.getRight() == null){
            node = null;
        }
        return deleteMax(node.getRight());
    }

    /**
     * 删除指定节点
     */
    public Node delNode(Node node, Integer delVal){
        //当前的节点就是要被删除的节点
        if(node.getValue().equals(delVal)){
            //左子树为空，直接删除，右子树的根节点替换到当前位置
            if(node.getLeft() == null){
                node = node.getRight();

                //右子树为空，直接删除，左子树的根节点替换到当前位置
            } else if(node.getRight() == null){
                node = node.getLeft();

                //左右子树都不为空
            }else{
                //找到右子树的最小值
                Node successNode = findMin(node.getRight());
                //删除右子树的最小值
                deleteMin(node.getRight());

                successNode.setLeft(node.getLeft());
                successNode.setRight(node.getRight());
                node = successNode;
            }
            return node;
            //继续递归，直到找到需要被删除的节点
        }else{
            if(node.getValue() > delVal){
                return delNode(node.getRight(), delVal);
            }else {
                return delNode(node.getLeft(), delVal);
            }
        }
    }
}
