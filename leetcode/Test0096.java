package leetcode;

/**
 * @author Mei Siman
 * @date 2020/8/11 10:48
 *
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Test0096 {
    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0]=1;
        g[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i]+= g[j-1]*g[i-j];
            }
        }
        return g[n];
    }
}
