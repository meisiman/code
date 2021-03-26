package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mei Siman
 * @date 2021/3/26 10:26
 *
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 */
public class Test0567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0,valid=0;
        while (right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).intValue()==need.get(c).intValue()) valid++;
            }
            while (right-left>=s1.length()){
                if (valid==need.size()) return true;
                char x = s2.charAt(left);
                left++;
                if (need.containsKey(x)){
                    if (need.get(x).intValue()==window.get(x).intValue()) valid--;
                    window.put(x,window.get(x)-1);
                }
            }
        }
        return false;
    }
}
