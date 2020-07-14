package offer;

import java.time.Period;

/**
 * @author Mei Siman
 * @date 2020/7/14 12:34
 *
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * leetcode426
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
// Definition for a Node.
class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {
    }

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class Offer36 {
    Node2 pre,head;
    public Node2 treeToDoublyList(Node2 root) {
        if(root==null) return null;
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;
    }

    void dfs(Node2 cur){
        if(cur==null) return;
        dfs(cur.left);
        if(pre!=null) pre.right=cur;
        else head=cur;
        cur.left=pre;
        pre=cur;
        dfs(cur.right);
    }
}
