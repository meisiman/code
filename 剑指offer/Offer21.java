package offer;

/**
 * @author Mei Siman
 * @date 2020/7/12 13:34
 *
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Offer21 {
    public int[] exchange(int[] nums){
        int i=0,j=nums.length-1;
        int tmp;
        while(i<j){
            while (i<j&&(nums[i]%2==1)) i++;
            while (i<j&&(nums[j]%2==0)) j--;
            tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        return nums;
    }
}
