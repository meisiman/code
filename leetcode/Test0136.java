package leetcode;

/**
 * @author Mei Siman
 * @date 2020/6/19 15:30
 *
 * 位运算
 */
public class Test0136 {
    public static int singleNumber(int[] nums) {
        int a=0;
        for (int num : nums) {
            a^=num;//异或
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,4};
        System.out.println(singleNumber(nums));
    }
}
