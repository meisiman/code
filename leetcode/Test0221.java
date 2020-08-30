package leetcode;

/**
 * @author Mei Siman
 * @date 2020/8/30 12:19
 *
 * 221. 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class Test0221 {
    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if (matrix==null||matrix.length==0||matrix[0].length==0) return maxSize;
        int rows = matrix.length,cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]=='1'){
                    if(i==0||j==0) dp[i][j]=1;
                    else dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    maxSize = Math.max(maxSize,dp[i][j]);
                }
            }
        }
        return maxSize*maxSize;
    }
}
