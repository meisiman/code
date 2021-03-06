package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mei Siman
 * @date 2020/6/7 10:41
 *
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 */
public class Test0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[]{map.get(num),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
