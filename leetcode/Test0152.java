package leetcode;

/**
 * @author Mei Siman
 * @date 2020/8/22 12:56
 *
 * 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Test0152 {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur_max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            int cur_min = Math.min(Math.min(max*nums[i],min*nums[i]),nums[i]);
            res = Math.max(res,cur_max);
            max = cur_max;
            min = cur_min;
        }
        return res;
    }
}
