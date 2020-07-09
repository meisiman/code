package leetcode;

import imooc.chap2.Array;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2020/6/29 13:01
 *
 *在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Test0215 {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,4};
        System.out.println(findKthLargest(nums, 1));
    }
}
