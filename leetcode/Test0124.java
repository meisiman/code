package leetcode;

/**
 * @author Mei Siman
 * @date 2020/8/16 13:59
 *
 * 124. 二叉树中的最大路径和
 */
public class Test0124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node==null) return 0;
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(maxGain(node.left),0);
        int right = Math.max(maxGain(node.right),0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int price = node.val + left + right;
        // 更新答案
        maxSum = Math.max(maxSum,price);
        // 返回节点的最大贡献值
        return node.val+Math.max(left,right);
    }
}
