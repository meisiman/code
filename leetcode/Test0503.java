package leetcode;

import java.util.Stack;

/**
 * @author Mei Siman
 * @date 2020/9/22 14:17
 *
 * 503. 下一个更大元素 II
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 */
public class Test0503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*nums.length-1; i >= 0; i--) {
            while (!stack.empty()&&nums[stack.peek()]<=nums[i%nums.length])
                stack.pop();
            res[i%nums.length]=stack.empty()?-1:nums[stack.peek()];
            stack.push(i%nums.length);
        }
        return res;
    }
}
