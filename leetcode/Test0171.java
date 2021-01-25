package leetcode;

/**
 * @author Mei Siman
 * @date 2021/1/25 19:05
 *
 * 171. Excel表列序号
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 */
public class Test0171 {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i)-'A'+1;
            ans = ans*26+num;
        }
        return ans;
    }
}
