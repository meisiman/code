package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mei Siman
 * @date 2020/7/14 13:54
 *
 * 剑指 Offer 37. 序列化二叉树
 * leetcode297
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class Offer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>(){{add(root);}};
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>(){{add(root);}};
        int i=1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
