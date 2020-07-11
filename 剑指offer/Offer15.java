package offer;

/**
 * @author Mei Siman
 * @date 2020/7/11 12:53
 *
 * 剑指 Offer 15. 二进制中1的个数
 * leetcode191
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 */
public class Offer15 {
    //n&(n-1)消除最低有效位
    public int hammingWeight(int n) {
        int res = 0;
        while (n!=0){
            res++;
            n&=(n-1);
        }
        return res;
    }
}
