package leetcode;

/**
 * @author Mei Siman
 * @date 2021/1/31 14:30
 *
 * 395. 至少有K个重复字符的最长子串
 *
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 */
public class Test0395 {
    public int longestSubstring(String s, int k) {
        int res = 0;
        boolean[] m = new boolean[26];
        int[] mid = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mid[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < mid.length; i++) {
            if (mid[i]<k) m[i]=true;
        }
        int start = 0;
        boolean f = true;
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)-'a']){
                f=false;
                if (start<i){
                    res = Integer.max(res,longestSubstring(s.substring(start,i),k));
                }
                start=i+1;
            }
        }
        if (f){
            res=s.length();
        }else {
            if (start<s.length()){
                res = Integer.max(res,longestSubstring(s.substring(start,s.length()),k));
            }
        }
        return res;
    }
}
