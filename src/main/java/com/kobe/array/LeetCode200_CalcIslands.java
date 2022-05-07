package com.kobe.array;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 */
public class LeetCode200_CalcIslands {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0}};
        System.out.println(new LeetCode200_CalcIslands().numIslands(grid));
    }

    public int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                num ++;
                dfsSet2Zero(grid, i, j);
            }
        }

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == 1){
                    //至少有一个岛
                    num ++;
                    dfsSet2Zero(grid, i, j);
                }
            }
        }

        return num;
    }

    private void dfsSet2Zero(int[][] grid, int i, int j){
        int row = grid.length;
        int col = grid[0].length;

        if (i >= row || i < 0 || j >= col || j <0 || grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;
        dfsSet2Zero(grid, i-1, j);
        dfsSet2Zero(grid, i+1, j);
        dfsSet2Zero(grid, i, j-1);
        dfsSet2Zero(grid, i, j+1);
    }
}
