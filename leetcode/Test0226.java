package leetcode;

/**
 * @author Mei Siman
 * @date 2020/8/31 13:06
 *
 * 226. 翻转二叉树
 */
public class Test0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right=left;
        root.left=right;
        return root;
    }
}
