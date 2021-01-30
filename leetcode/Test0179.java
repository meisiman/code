package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mei Siman
 * @date 2021/1/29 14:30
 *
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Test0179 {
    private class LargerNumberComparator implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            String o1 = a+b;
            String o2 = b+a;
            return o2.compareTo(o1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs,new LargerNumberComparator());
        if (asStrs[0].equals("0")) return "0";
        String res = new String();
        for (String str : asStrs) {
            res += str;
        }
        return res;
    }
}
