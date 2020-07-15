package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mei Siman
 * @date 2020/7/15 16:41
 *
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * leetcode3
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic = new HashMap<>();
        int i = -1,res = 0;
        for (int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i,dic.get(s.charAt(j)));
            dic.put(s.charAt(j),j);
            res = Math.max(res,j-i);
        }
        return res;
    }
}
