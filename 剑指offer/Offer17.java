package offer;

/**
 * @author Mei Siman
 * @date 2020/7/11 16:33
 *
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Offer17 {
    public int[] printNumbers(int n){
        int end = (int)Math.pow(10,n)-1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i]=i+1;
        }
        return res;
    }
}
