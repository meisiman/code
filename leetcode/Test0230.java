package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2021/1/26 23:40
 *
 * 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 */
public class Test0230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = inorder(root,new ArrayList<>());
        return nums.get(k-1);
    }

    ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> arr){
        if (root==null) return arr;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return arr;
    }
}
