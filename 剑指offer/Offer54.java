package offer;

/**
 * @author Mei Siman
 * @date 2020/7/16 21:11
 *
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Offer54 {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.right);
        if(k==0) return;
        if(--k==0) res=root.val;
        dfs(root.left);
    }
}
