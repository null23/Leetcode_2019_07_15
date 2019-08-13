package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * MidNum
 * 将二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class _114 {

    /**
     * 思路：
     *  可以发现展开的顺序其实就是二叉树的先序遍历。算法和 94 题 中序遍历的 Morris 算法有些神似，我们需要两步完成这道题。
     *  1.将左子树插入到右子树的地方
     *  2.将原来的右子树接到左子树的最右边节点
     *  3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     *
     *  时间复杂度：O(n)
     */
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.getLeft() != null){
                TreeNode pre = root.getLeft();
                while(pre.getRight() != null){
                    pre = pre.getRight();
                }
                pre.setRight(root.getRight());
                root.setRight(root.getLeft());
                root.setLeft(null);
            }
            root = root.getRight();
        }
    }
}
