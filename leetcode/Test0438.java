package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mei Siman
 * @date 2021/3/26 10:33
 *
 * 438. 找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 */
public class Test0438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (char c : p.toCharArray()) {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0,valid=0;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).intValue()==need.get(c).intValue()) valid++;
            }
            while (right-left>=p.length()){
                if (valid==need.size()) res.add(left);
                char x = s.charAt(left);
                left++;
                if (need.containsKey(x)){
                    if (need.get(x).intValue()==window.get(x).intValue()) valid--;
                    window.put(x,window.get(x)-1);
                }
            }
        }
        return res;
    }
}
