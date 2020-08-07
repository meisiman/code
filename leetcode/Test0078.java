package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/8/7 14:27
 *
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 回溯
 */
public class Test0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        back(nums,0,new LinkedList<>(),res);
        return res;
    }

    public void back(int[] nums, int current, LinkedList<Integer> track,List<List<Integer>> res){
        if(current==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        //不选当前元素
        back(nums,current+1,track,res);
        //选当前元素
        track.add(nums[current]);
        back(nums,current+1,track,res);
        //撤销选取当前元素（回溯）
        track.removeLast();
    }
}
