package offer;

/**
 * @author Mei Siman
 * @date 2020/7/18 13:10
 *
 * 剑指 Offer 64. 求1+2+…+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Offer64 {
    int res = 0;
    public int sumNums(int n) {
        boolean x=n>1&&sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
