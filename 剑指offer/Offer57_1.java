package offer;

/**
 * @author Mei Siman
 * @date 2020/7/17 14:32
 *
 * 剑指 Offer 57. 和为s的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Offer57_1 {
    public int[] twoSum(int[] nums, int target) {
        int a=0,b=nums.length-1;
        while (a<b){
            if(nums[a]+nums[b]==target) return new int[]{nums[a],nums[b]};
            else if(nums[a]+nums[b]<target) a++;
            else b--;
        }
        return new int[]{nums[a],nums[b]};
    }
}
