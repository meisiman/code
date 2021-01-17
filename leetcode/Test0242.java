package leetcode;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2021/1/16 19:52
 *
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class Test0242 {
    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }
}
