package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mei Siman
 * @date 2020/11/20 9:17
 *
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 */
public class Test0435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length-intervalSchedule(intervals);
    }

    //求无重叠区间
    public int intervalSchedule(int[][] intervals){
        if (intervals.length==0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int last = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0]>=last){
                count++;
                last=interval[1];
            }
        }
        return count;
    }
}
