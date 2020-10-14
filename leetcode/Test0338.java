package leetcode;

/**
 * @author Mei Siman
 * @date 2020/10/14 9:36
 *
 * 338. 比特位计数
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class Test0338 {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for (int i = 0; i <= num; i++) {
            ans[i]=popcount(i);
        }
        return ans;
    }

    private int popcount(int x){
        int count;
        for (count = 0; x != 0; ++count) {
            x&=x-1;//消除最低有效位
        }
//        while (x!=0){
//            ++count;
//            x&=x-1;
//        }
        return count;
    }
}
