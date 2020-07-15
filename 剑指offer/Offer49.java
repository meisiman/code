package offer;

/**
 * @author Mei Siman
 * @date 2020/7/15 16:58
 *
 * 剑指 Offer 49. 丑数
 * leetcode264
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class Offer49 {
    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] dp = new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            int n2=dp[a]*2,n3=dp[b]*3,n5=dp[c]*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if(dp[i]==n2) a++;
            if(dp[i]==n3) b++;
            if(dp[i]==n5) c++;
        }
        return dp[n-1];
    }
}

