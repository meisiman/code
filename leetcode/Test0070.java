package leetcode;

/**
 * @author Mei Siman
 * @date 2020/6/11 11:21
 *
 * 动态规划
 */
public class Test0070 {
    public static int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] arr = new int[n+1];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<=n;i++)
            arr[i]=arr[i-1]+arr[i-2];
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
