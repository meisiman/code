package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mei Siman
 * @date 2021/1/25 19:12
 *
 * 454. 四数相加 II
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 */
public class Test0454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int u : A) {
            for (int v : B) {
                count.put(u+v,count.getOrDefault(u+v,0)+1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (count.containsKey(-u-v))
                    ans+=count.get(-u-v);
            }
        }
        return ans;
    }
}
