package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/31 12:18
 *
 * 45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 */
public class Test0045 {
    public int jump(int[] nums) {
        int n=nums.length;
        int end=0;
        int max=0;
        int steps=0;
        for (int i = 0; i < n-1; i++) {
            if(i<=max){
                max = Math.max(max,i+nums[i]);
                if(i==end) {
                    end = max;
                    steps++;
                }
            }
        }
        return steps;
    }
}
