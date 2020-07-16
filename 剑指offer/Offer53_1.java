package offer;

/**
 * @author Mei Siman
 * @date 2020/7/16 20:06
 *
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * leetcode34
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class Offer53_1 {
    public int search(int[] nums, int target) {
        return helper(nums,target)-helper(nums,target-1);
    }

    int helper(int[] nums,int tar){
        int i=0,j=nums.length-1;
        while (i<=j){
            int m=(i+j)/2;
            if(nums[m]<=tar) i=m+1;
            else j=m-1;
        }
        return i;
    }
}
