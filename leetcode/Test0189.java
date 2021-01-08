package leetcode;

/**
 * @author Mei Siman
 * @date 2021/1/8 16:51
 *
 * 189. 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Test0189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[(i+k)%n]=nums[i];
        }
        System.arraycopy(dp,0,nums,0,n);
    }
}
