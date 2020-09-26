package leetcode;

/**
 * @author Mei Siman
 * @date 2020/9/26 10:20
 *
 * 239. 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 */
public class Test0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n*k==0) return new int[0];
        if (k==1) return nums;

        int[] left = new int[n];
        left[0]=nums[0];
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            //from left to right
            if (i%k==0) left[i]=nums[i];
            else left[i] = Math.max(left[i-1],nums[i]);

            //from right to left
            int j=n-i-1;
            if((j+1)%k==0) right[j]=nums[j];
            else right[j]=Math.max(right[j+1],nums[j]);
        }
        int[] output = new int[n-k+1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i+k-1],right[i]);
        }
        return output;
    }
}
