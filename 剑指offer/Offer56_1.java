package offer;

/**
 * @author Mei Siman
 * @date 2020/7/16 21:32
 *
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int k=0;
        for (int num : nums) {
            k^=num;
        }

        //获得k中最低位的1
        int mask=1;
        while ((k&mask)==0){
            mask<<=1;
        }

        int a=0,b=0;
        for (int num : nums) {
            if((num&mask)==0) a^=num;
            else b^=num;
        }

        return new int[]{a,b};
    }
}
