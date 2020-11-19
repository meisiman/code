package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mei Siman
 * @date 2020/11/19 15:29
 *
 * 354. 俄罗斯套娃信封问题
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 */
public class Test0354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o2[1]-o1[1];
                else return o1[0]-o2[0];
            }
        });
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }

    public int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        int len=0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp,0,len,num);
            if (i<0) i=-(i+1);
            dp[i]=num;
            if (i==len) len++;
        }
        return len;
    }
}
