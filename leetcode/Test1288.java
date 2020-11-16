package leetcode;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2020/11/16 15:29
 *
 * 1288. 删除被覆盖区间
 *
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 */
public class Test1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if (a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            if (left<=intv[0] && right>=intv[1]) res++;
            if (right>=intv[0] && right<=intv[1]) right=intv[1];
            if (right<intv[0]){
                left=intv[0];
                right=intv[1];
            }
        }
        return intervals.length-res;
    }
}
