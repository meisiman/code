package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/9 14:44
 *
 * 509. 斐波那契数
 */
public class Test0509 {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N-1) + fib(N-2);
    }

    //动态规划
    public int fib_2(int N) {
        int[] fibArray = new int[N + 1];
        fibArray[0] = 0;
        if(N > 0) fibArray[1] = 1;
        for(int i = 2; i <= N; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray[N];
    }
}
