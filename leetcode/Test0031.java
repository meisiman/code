package leetcode;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2020/7/22 15:21
 *
 * 31. 下一个排列
 */
public class Test0031 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = nums.length-1; j > i; j--) {
                if(nums[i]<nums[j]){
                    swap(nums,i,j);
                    Arrays.sort(nums,i+1,nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
