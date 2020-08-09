package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Mei Siman
 * @date 2020/8/9 11:56
 *
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Test0084 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxVal = 0;
        for (int i = 0; i <= len; i++) {
            int cur = i<len?heights[i]:0;
            while (stack.peek()!=-1&&heights[stack.peek()]>cur){
                int temp = stack.pop();
                int width = i-stack.peek()-1;
                maxVal = Math.max(maxVal,width*heights[temp]);
            }
            stack.push(i);
        }
        return maxVal;
    }
}
