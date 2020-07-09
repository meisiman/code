package leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2020/6/25 11:28
 * <p>
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词.
 */
public class Test0139 {
    HashMap<String, Boolean> hash = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean dp[] = new boolean[s.length() + 1];

        //方便check，构建一个哈希表
        for (String word : wordDict) {
            hash.put(word, true);
        }

        //初始化
        dp[0] = true;

        //遍历
        for (int j = 1; j <= s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[j] = dp[i] && check(s.substring(i, j));
                if (dp[j])
                    break;
            }
        }

        return dp[s.length()];
    }

    public boolean check(String s) {
        return hash.getOrDefault(s, false);//当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
    }
}
