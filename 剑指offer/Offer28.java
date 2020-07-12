package offer;

/**
 * @author Mei Siman
 * @date 2020/7/12 18:04
 * <p>
 * 剑指 Offer 28. 对称的二叉树
 * leetcode101
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
