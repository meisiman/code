package leetcode;

import java.util.*;

/**
 * @author Mei Siman
 * @date 2020/7/26 12:22
 *
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 */
public class Test0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates,len,target,0,new ArrayDeque<>(),res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs(int[] candidates, int len, int residue, int begin, Deque<Integer> path,List<List<Integer>> res){
        if(residue==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //在数组有序的前提下，剪枝
            if(residue-candidates[i]<0) break;
            path.addLast(candidates[i]);
            dfs(candidates,len,residue-candidates[i],i,path,res);
            path.removeLast();
        }
    }
}
