package leetcode;

import java.util.Arrays;

/**
 * @author Mei Siman
 * @date 2021/1/16 20:10
 *
 * 387. 字符串中的第一个唯一字符
 */
public class Test0387 {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
