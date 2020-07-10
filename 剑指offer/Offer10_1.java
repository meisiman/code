package offer;

/**
 * @author Mei Siman
 * @date 2020/7/10 13:01
 *
 * 剑指 Offer 10- I. 斐波那契数列
 * 与leetcode509相同
 */
public class Offer10_1 {
    public int fib(int n) {
        int[] arr = new int[n+1];
        arr[0]=0;
        if(n>0) arr[1]=1;
        for (int i = 2; i <= n; i++) {
            arr[i]=arr[i-1]+arr[i-2];
            arr[i]%=1000000007;
        }
        return arr[n];
    }

    public int fib_2(int n){
        int a=0,b=1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }
}
