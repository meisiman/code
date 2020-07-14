package offer;

/**
 * @author Mei Siman
 * @date 2020/7/14 15:24
 *
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * leetcode169
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int x=0,votes=0,count=0;
        for (int num : nums) {
            if(votes==0) x=num;
            votes += num == x ? 1 : -1;
        }
        //验证x是否为众数
        for (int num : nums)
            if(num==x) count++;
        return count>nums.length/2?x:0;//无众数返回0
    }
}
