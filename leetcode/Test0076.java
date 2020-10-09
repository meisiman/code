package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Mei Siman
 * @date 2020/10/9 10:38
 *
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T 。
 * 请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 */
public class Test0076 {
    Map<Character,Integer> ori = new HashMap<>();
    Map<Character,Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        int l=0,r=-1;
        int len = Integer.MAX_VALUE,ansL=-1,ansR=-1;
        int SLen = s.length();
        while (r<SLen){
            ++r;
            if (r<SLen && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            while (check() && l<=r){
                if (r-l+1<len){
                    len=r-l+1;
                    ansL=l;
                    ansR=l+len;
                }
                if (ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0)-1);
                }
                ++l;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR);
    }

    public boolean check(){
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key,0)<val) return false;
        }
        return true;
    }
}
