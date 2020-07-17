package offer;

/**
 * @author Mei Siman
 * @date 2020/7/17 13:44
 *
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Offer56_2 {
    public int singleNumber(int[] nums){
        if(nums.length==0) return -1;
        int[] bitSum = new int[32];
        int res = 0;
        for (int num : nums) {
            int bitMask=1;
            for (int i = 31; i >= 0; i--) {
                if((num&bitMask)!=0) bitSum[i]++;
                bitMask<<=1;
            }
        }
        for (int i = 0; i < 32; i++) {
            res<<=1;
            res+=bitSum[i]%3;
        }
        return res;
    }
}
