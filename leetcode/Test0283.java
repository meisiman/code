package leetcode;

/**
 * @author Mei Siman
 * @date 2020/9/29 14:54
 *
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Test0283 {
    public void moveZeroes(int[] nums) {
        if(nums==null) return;
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0) nums[j++]=nums[i];
        }

        for (int i = j; i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
