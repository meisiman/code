package leetcode;

/**
 * @author Mei Siman
 * @date 2020/7/27 11:46
 *
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Test0042 {
    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                if (max_left > height[left]) {
                    sum += (max_left - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                if (max_right > height[right]) {
                    sum += (max_right - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
