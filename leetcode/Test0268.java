package leetcode;

/**
 * @author Mei Siman
 * @date 2021/2/9 13:10
 *
 * 268. 丢失的数字
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class Test0268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        for (int num : nums) {
            sum-=num;
        }
        return sum;
    }
}
