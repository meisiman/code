package leetcode;

/**
 * @author Mei Siman
 * @date 2020/10/25 9:51
 *
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *      每个数组中的元素不会超过 100
 *      数组的大小不会超过 200
 *
 */
public class Test0416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n<2) return false;
        int sum=0,maxNum=0;
        for (int num : nums) {
            sum+=num;
            maxNum=Math.max(maxNum,num);
        }
        if (sum%2!=0) return false;
        int target = sum/2;
        if (maxNum>target) return false;

        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j-num];
            }
        }
        return dp[target];
    }
}
