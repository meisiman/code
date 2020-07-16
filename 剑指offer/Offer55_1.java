package offer;

/**
 * @author Mei Siman
 * @date 2020/7/16 21:20
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 * leetcode104
 *
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Offer55_1 {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
