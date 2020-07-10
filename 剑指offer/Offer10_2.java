package offer;

/**
 * @author Mei Siman
 * @date 2020/7/10 13:02
 *
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * leetcode70
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class Offer10_2 {
    public int numWays(int n) {
        int[] num= new int[n+1];
        num[0]=1;
        if(n>0) num[1]=1;
        for (int i = 2; i <= n; i++) {
            num[i]=num[i-1]+num[i-2];
            num[i]%=1000000007;
        }
        return num[n];
    }
}
