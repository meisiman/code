package leetcode;

/**
 * @author Mei Siman
 * @date 2020/10/24 9:23
 *
 * 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class Test0543 {
    int max=0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode node){
        if (node==null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        max= Math.max(left+right,max);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(left,right)+1;//返回节点深度
    }
}
