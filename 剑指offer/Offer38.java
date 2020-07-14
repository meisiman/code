package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/7/14 14:34
 *
 * 剑指 Offer 38. 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 */
public class Offer38 {
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c=s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x){
        if(x==c.length-1){
            res.add(String.valueOf(c));//添加排序方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue;//重复，剪枝
            set.add(c[i]);
            swap(i,x);//交换，将c[i]固定在第x位
            dfs(x+1);//开启固定x+1位字符
            swap(i,x);//恢复交换
        }
    }

    void swap(int a,int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
