package leetcode;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2020/7/2 17:05
 */
public class Test0004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
        for (int i : nums3) {
            System.out.print(i);
            System.out.println();
        }
        Arrays.sort(nums3);
        if(nums3.length==0) return 0;
        else if (nums3.length % 2 == 1)
            return nums3[nums3.length / 2];
        else{
            return (double)(nums3[nums3.length / 2 - 1] + nums3[nums3.length/2]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
