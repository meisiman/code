package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/7/13 17:37
 *
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Offer34 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);
        return res;
    }

    void recur(TreeNode root,int tar){
        if(root==null) return;
        path.add(root.val);
        tar-=root.val;
        if(tar==0&&root.left==null&root.right==null)
            res.add(new LinkedList(path));
        recur(root.left,tar);
        recur(root.right,tar);
        path.removeLast();
    }
}
