package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/31 11:32
 *
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */
public class Test0055 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int max=0;
        for (int i = 0; i < n; i++) {
            if(i<=max){
                max = Math.max(max,i+nums[i]);
                if(max>=n-1) return true;
            }
        }
        return false;
    }
}
