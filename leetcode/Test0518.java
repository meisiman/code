package leetcode;

/**
 * @author Mei Siman
 * @date 2020/11/10 15:36
 *
 * 518. 零钱兑换 II
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */
public class Test0518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j>=coins[i]) dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
