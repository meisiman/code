package leetcode;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2021/1/29 17:17
 *
 *  324. 摆动排序 II
 *
 *  给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 */
public class Test0324 {
    public void wiggleSort(int[] nums) {
        int[] help = nums.clone();
        Arrays.sort(help);
        int n = nums.length;
        for (int i = 1; i < nums.length; i+=2) {
            nums[i] = help[--n];
        }
        for (int i = 0; i < nums.length; i+=2) {
            nums[i] = help[--n];
        }
    }
}
