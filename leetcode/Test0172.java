package leetcode;

/**
 * @author Mei Siman
 * @date 2021/2/8 16:26
 *
 * 172. 阶乘后的零
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class Test0172 {
    public int trailingZeroes(int n) {
        int count=0;
        while (n>=5){
            count+=n/5;
            n/=5;
        }
        return count;
    }
}
