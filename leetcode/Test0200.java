package leetcode;

/**
 * @author Mei Siman
 * @date 2020/8/26 14:41
 *
 * 200. 岛屿数量
 *
 *
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

 */
public class Test0200 {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if(grid[r][c]=='1'){
                    ++num;
                    dfs(grid,r,c);
                }
            }
        }
        return num;
    }

    void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if(r<0||c<0||r>=nr||c>=nc||grid[r][c]=='0') return;

        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}
