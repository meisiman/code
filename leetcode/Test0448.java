package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Mei Siman
 * @date 2020/10/7 7:57
 *
 * 448. 找到所有数组中消失的数字
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 */
public class Test0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer,Boolean> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i],true);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(i+1)) list.add(i+1);
        }
        return list;
    }
}
