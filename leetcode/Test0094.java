package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/8/11 10:33
 *
 * 94. 二叉树的中序遍历
 */
public class Test0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root,List<Integer> res){
        if(root!=null){
            if(root.left!=null) helper(root.left,res);
            res.add(root.val);
            if(root.right!=null) helper(root.right,res);
        }
    }
}
