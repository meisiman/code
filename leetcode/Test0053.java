package leetcode;

/**
 * @author Mei Siman
 * @date 2020/6/10 15:44
 */
public class Test0053 {
    public static int maxSubArray(int[] nums) {
        int[] arr = new int[nums.length];//动态规划，存放最大值
        int max = nums[0];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.max(arr[i - 1] + nums[i], nums[i]);
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int num = maxSubArray(nums);
        System.out.println(num);
    }
}
