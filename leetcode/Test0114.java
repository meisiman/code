package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/8/15 15:40
 *
 * 114. 二叉树展开为链表
 */
public class Test0114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        pre(root,list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i-1),curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void pre(TreeNode root,List<TreeNode> list) {
        if(root!=null){
            list.add(root);
            pre(root.left,list);
            pre(root.right,list);
        }
    }
}
