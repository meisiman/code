package offer;

/**
 * @author Mei Siman
 * @date 2020/7/17 15:05
 *
 * 剑指 Offer 58 - I. 翻转单词顺序
 * leetcode151
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 */
public class Offer58_1 {
    public String reverseWords(String s) {
        s.trim();
        int j=s.length()-1,i=j;
        StringBuilder res = new StringBuilder();
        while (i>=0){
            while (i>=0&&s.charAt(i)!=' ') i--;
            res.append(s.substring(i+1,j+1)+ " ");
            while (i>=0&&s.charAt(i)==' ') i--;
            j=i;
        }
        return res.toString().trim();
    }
}
