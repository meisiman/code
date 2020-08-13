package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/8/13 13:41
 *
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Test0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()>0) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) queue.add(t.left);
                if(t.right!=null) queue.add(t.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
