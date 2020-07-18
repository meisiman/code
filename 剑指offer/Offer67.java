package offer;

/**
 * @author Mei Siman
 * @date 2020/7/18 13:52
 *
 * 剑指 Offer 67. 把字符串转换成整数
 * leetcode8
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 */
public class Offer67 {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length==0) return 0;
        int res=0,boundary=Integer.MAX_VALUE/10;
        int i=1,sign=1;
        if(c[0] == '-') sign=-1;
        else if(c[0]!='+') i=0;
        for (int j=i;j<c.length;j++){
            if(c[j]<'0'||c[j]>'9') break;
            if(res>boundary||res==boundary&&c[j]>'7') return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res*10+(c[j]-'0');
        }
        return sign*res;
    }
}
