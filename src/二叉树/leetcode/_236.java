package 二叉树.leetcode;

import 二叉树.Tree.TreeNode;

/**
 * MidNum
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 */
public class _236 {
    TreeNode res = null;

    /**
     * 思路：
     * 这类题，都有一个统一的思路，那就是分别递归遍历左右子树，然后通过左右子树的遍历结果，获得最终值。
     * 类似的题目比如：求二叉树的深度，在求深度的时候，我们分别递归左右子树的深度的结果，然后返回 Min(leftDepth, rightDepth) + 1 作为当前节点的深度
     *
     * 这道题也是类似的，分别求当前节点的左右子树是否分别包含目标节点p或q，如果包含，那么当前节点即为所求
     * 但是这道题还有另一种情况，那就是目标节点本身也可以作为共公共祖先，也就是p和q也可能是当前的祖先
     *
     * 那么，就应该维护三个条件变量：p或q是否在左子树，p或q是否在右子树，p或q是否是当前节点
     * 只要满足以上三个条件中的任意两种，就说明当前节点是公共祖先
     *
     * 自底向上递归
     * 时间复杂度：O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    public int helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return 0;
        }
        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);

        int mid = 0;
        if(root.val == p.val || root.val == q.val){
            mid = 1;
        }

        if(left + right + mid > 1 && res == null){
            res = root;
        }
        return left + right + mid;
    }
}
