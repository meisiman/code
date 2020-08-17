package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mei Siman
 * @date 2020/8/17 11:12
 *
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 */
public class Test0128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longest = 0;
        for (Integer num : num_set) {
            if(!num_set.contains(num-1)){
                int curNum = num;
                int cur = 1;

                while (num_set.contains(curNum+1)){
                    curNum+=1;
                    cur+=1;
                }
                longest = Math.max(longest,cur);
            }
        }
        return longest;
    }
}
