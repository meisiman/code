package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Mei Siman
 * @date 2020/7/17 16:31
 *
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * leetcode239
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Offer59_1 {
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length==0||k==0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int j=0,i=1-k;j<nums.length;i++,j++){
            if(i>0&&deque.peekFirst()==nums[i-1]) deque.removeFirst();
            while (!deque.isEmpty()&&deque.peekLast()<nums[j]) deque.removeLast();
            deque.addLast(nums[j]);
            if(i>=0) res[i] = deque.peekFirst();
        }
        return res;
    }
}
