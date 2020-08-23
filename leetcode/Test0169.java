package leetcode;

/**
 * @author Mei Siman
 * @date 2020/8/23 13:06
 *
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class Test0169 {
    public int majorityElement(int[] nums) {
        int count=0;
        int elem =nums[0];
        for (int num : nums) {
            if(count==0) elem=num;
            count+=(num==elem)?1:-1;
        }
        return elem;
    }
}
