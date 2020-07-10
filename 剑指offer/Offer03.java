package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mei Siman
 * @date 2020/7/9 14:54
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 */
public class Offer03 {
    public static int findRepeatNumber(int[] nums) {
        Set set = new HashSet();
        for (int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]))
                set.add(nums[i]);
            else return nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
