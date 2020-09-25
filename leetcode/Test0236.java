package leetcode;

/**
 * @author Mei Siman
 * @date 2020/9/25 10:50
 *
 * 236. 二叉树的最近公共祖先
 */
public class Test0236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q) return root;
        if(root!=null){
            TreeNode lNode = lowestCommonAncestor(root.left,p,q);
            TreeNode rNode = lowestCommonAncestor(root.right,p,q);
            if(lNode!=null&&rNode!=null) return root;
            else if (lNode==null) return rNode;//两个都在右子树
            else return lNode;//两个都在左子树
        }
        return null;
    }
}