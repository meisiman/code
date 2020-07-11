package offer;

/**
 * @author Mei Siman
 * @date 2020/7/11 11:13
 *
 * 剑指 Offer 14- I. 剪绳子
 * leetcode343
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 */
public class Offer14_1 {
    //动态规划
    public int cuttingRope1(int n) {
        if(n <= 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for(int j = 4;j <= n;j++){
            int max = Integer.MIN_VALUE;
            for(int i = 1;i <= j/2;i++){
                max = Math.max(max, dp[i] * dp[j-i]);
            }
            dp[j] = max;
        }
        return dp[n];
    }

    //数学推导(贪心算法)
    public int cuttingRope(int n){
        if(n<=3) return n-1;
        int a=n/3,b=n%3;
        if(b==0) return (int)Math.pow(3,a);
        if(b==1) return (int)Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a)*2;//b==2
    }
}
