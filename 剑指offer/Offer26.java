package offer;

/**
 * @author Mei Siman
 * @date 2020/7/12 16:07
 *
 * 剑指 Offer 26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null) return false;
        if(A.val==B.val&&(recur(A.left,B.left)&&recur(A.right,B.right))) return true;
        return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    //判断
    boolean recur(TreeNode A, TreeNode B){
        if(B==null) return true;
        if(A==null||A.val!=B.val) return false;
        return recur(A.right,B.right)&&recur(A.left,B.left);
    }
}
