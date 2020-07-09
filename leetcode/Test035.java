package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/9 14:44
 */
public class Test035 {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
