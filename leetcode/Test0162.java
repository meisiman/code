package leetcode;

/**
 * @author Mei Siman
 * @date 2021/1/29 17:25
 *
 * 162. 寻找峰值
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 */
public class Test0162 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i]>nums[i+1]) return i;
        }
        return nums.length-1;
    }
}
