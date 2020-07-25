package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/25 11:44
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 */
public class Test0034 {
    public int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }else {//target==nums[mid]
                while (nums[left]!=target) left++;
                while (nums[right]!=target) right--;
                return new int[]{left,right};
            }
        }
        return new int[]{-1,-1};
    }
}
