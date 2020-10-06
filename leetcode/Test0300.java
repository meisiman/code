package leetcode;

/**
 * @author Mei Siman
 * @date 2020/10/6 20:20
 *
 * 300. 最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class Test0300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0]=1;
        int maxAns=1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal=0;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]) maxVal=Math.max(maxVal,dp[j]);
            }
            dp[i]=maxVal+1;
            maxAns=Math.max(maxAns,dp[i]);
        }
        return maxAns;
    }
}
