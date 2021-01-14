package leetcode;

/**
 * @author Mei Siman
 * @date 2021/1/14 17:16
 *
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class Test0125 {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n=sgood.length();
        int left=0,right=n-1;
        while (left<right){
            if (sgood.charAt(left)!=sgood.charAt(right)) return false;
            ++left;
            --right;
        }
        return true;
    }
}
