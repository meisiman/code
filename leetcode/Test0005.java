package leetcode;

/**
 * @author Mei Siman
 * @date 2020/6/27 12:45
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串
 */
public class Test0005 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;


        int maxLen = 1;
        int begin = 0;

        //dp[i][j]表示s[i,j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //只要dp[i][j] = true成立，就表示字串s[i...j]是回文串
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "abcbad";
        System.out.println(longestPalindrome(s));
    }
}
