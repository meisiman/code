package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/24 13:01
 *
 * 33. 搜索旋转排序数组
 */
public class Test0033 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[left]) {
                if(target>=nums[left]&&target<nums[mid]) right=mid-1;
                else left=mid+1;
            }
            else {
                if(target>nums[mid]&&target<=nums[right]) left=mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }
}
