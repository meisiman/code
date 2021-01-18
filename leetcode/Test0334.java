package leetcode;

/**
 * @author Mei Siman
 * @date 2021/1/18 16:27
 *
 * 334. 递增的三元子序列
 *
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 */
public class Test0334 {
    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE,two = Integer.MAX_VALUE;
        for (int three : nums) {
            if (three > two) return true;
            else if (three <= one) one = three;
            else two = three;
        }
        return false;
    }
}
