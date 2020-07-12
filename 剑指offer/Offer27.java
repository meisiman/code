package offer;

/**
 * @author Mei Siman
 * @date 2020/7/12 17:55
 *
 * 剑指 Offer 27. 二叉树的镜像
 * leetcode226
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
