package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/9 14:37
 *
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Test0101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
