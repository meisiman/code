package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2021/1/15 14:07
 *
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 */
public class Test0131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len==0) return res;
        Deque<String> stack = new ArrayDeque<>();
        backtrack(s,0,len,stack,res);
        return res;
    }

    void backtrack(String s, int start, int len, Deque<String> path,List<List<String>> res){
        if (start==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<len;i++){
            if (!checkPalindrome(s,start,i)) continue;
            path.addLast(s.substring(start,i+1));
            backtrack(s,i+1,len,path,res);
            path.removeLast();
        }
    }

    boolean checkPalindrome(String str,int left,int right){
        while (left<right){
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
