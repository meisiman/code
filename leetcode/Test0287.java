package leetcode;

/**
 * @author Mei Siman
 * @date 2020/10/2 10:14
 *
 * 287. 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 *
 * 快慢指针
 *
 */
public class Test0287 {
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
