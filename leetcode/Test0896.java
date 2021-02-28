package leetcode;

/**
 * @author Mei Siman
 * @date 2021/2/28 17:24
 *
 * 896. 单调数列
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 */
public class Test0896 {
    public boolean isMonotonic(int[] A) {
        boolean a=true,b=true;
        for (int i = 0; i < A.length-1; i++) {
            if (A[i]>A[i+1]) a=false;
            if (A[i]<A[i+1]) b=false;
        }
        return a||b;
    }
}
