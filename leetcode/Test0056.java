package leetcode;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2020/8/1 11:23
 *
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Test0056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if(idx==-1||interval[0]>res[idx][1]){
                res[++idx]=interval;
            }else {
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,idx+1);
    }
}
