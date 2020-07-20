package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/7/20 14:13
 *
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Test022 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans,StringBuilder cur,int open,int close,int max){
        if(cur.length()==max*2){
            ans.add(cur.toString());
            return;
        }
        if(open<max){//如果左括号数量不大于 n，我们可以放一个左括号。
            cur.append('(');
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);//reset
        }
        if(close<open){//如果右括号数量小于左括号的数量，我们可以放一个右括号。
            cur.append(')');
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);//reset
        }
    }
}
