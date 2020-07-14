package offer;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2020/7/14 15:58
 *
 * 剑指 Offer 40. 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] nums = new int[k];
        for (int i=0;i<k;i++)
            nums[i]=arr[i];
        return nums;
    }
}
