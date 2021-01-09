package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2021/1/9 14:36
 *
 * 51. N 皇后
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 */
public class Test0051 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (char[] chars : chess) {
            Arrays.fill(chars,'.');
        }
        backtrack(chess,0);
        return res;
    }

    void backtrack(char[][] chess,int row){
        if (row==chess.length){
            res.add(construct(chess));
            return;
        }
        for (int col=0;col<chess.length;col++){
            if (valid(chess,row,col)){
                chess[row][col]='Q';
                backtrack(chess,row+1);
                chess[row][col]='.';
            }
        }
    }

    boolean valid(char[][] chess,int row,int col){
        for (int i = 0; i < row; i++) {
            if (chess[i][col]=='Q') return false;
        }
        for (int i=row-1,j=col+1;i>=0&&j<chess.length;i--,j++){
            if (chess[i][j]=='Q') return false;
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (chess[i][j]=='Q') return false;
        }
        return true;
    }

    private List<String> construct(char[][] chess){
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}
