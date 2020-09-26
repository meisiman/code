package leetcode;

/**
 * @author Mei Siman
 * @date 2020/9/26 9:39
 *
 * 238. 除自身以外数组的乘积
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 */
public class Test0238 {
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int[] ans = new int[nums.length];
        l[0]=1;
        for (int i = 1; i < nums.length; i++) {
            l[i]=l[i-1]*nums[i-1];
        }
        r[nums.length-1]=1;
        for (int i = nums.length-2; i >= 0; i--) {
            r[i]=r[i+1]*nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i]=l[i]*r[i];
        }
        return ans;
    }
}
