package leetcode;

/**
 * @author Mei Siman
 * @date 2020/9/27 9:59
 *
 * 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Test0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while (row>=0 && col<matrix[0].length) {
            if (matrix[row][col]>target) row--;
            else if (matrix[row][col]<target) col++;
            else return true;
        }
        return false;
    }
}
