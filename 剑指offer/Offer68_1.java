package offer;

/**
 * @author Mei Siman
 * @date 2020/7/18 15:02
 *
 * 面试题68 - I. 二叉搜索树的最近公共祖先
 * leetcode235
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Offer68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if(root.val<p.val&&root.val<q.val) root = root.right;
            else if(root.val>p.val&&root.val>q.val) root = root.left;
            else break;
        }
        return root;
    }
}
