package offer;

import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/7/9 16:43
 *
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 使用前序遍历的第一个元素创建根节点。
 * 创建一个栈，将根节点压入栈内。
 * 初始化中序遍历下标为 0。
 * 遍历前序遍历的每个元素，判断其上一个元素（即栈顶元素）是否等于中序遍历下标指向的元素。
 *      1、若上一个元素不等于中序遍历下标指向的元素，则将当前元素作为其上一个元素的左子节点，并将当前元素压入栈内。
 *      2、若上一个元素等于中序遍历下标指向的元素，则从栈内弹出一个元素，同时令中序遍历下标指向下一个元素，
 *         之后继续判断栈顶元素是否等于中序遍历下标指向的元素，若相等则重复该操作，直至栈为空或者元素不相等。
 *         然后令当前元素为最后一个想等元素的右节点，并压入栈中。
 * 遍历结束，返回根节点。
 *
 *
 */
public class Offer07 {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        if(preorder==null||preorder.length==0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex=0;//中序遍历下标
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if(node.val!=inorder[inorderIndex]){
                node.left=new TreeNode(preorder[i]);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty()&&stack.peek().val==inorder[inorderIndex]){
                    node=stack.pop();
                    inorderIndex++;
                }
                node.right=new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }
}
