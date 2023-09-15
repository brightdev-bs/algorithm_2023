package grind75.graph;

public class NumberOfIslands {

    int[] dr = { -1, 0, 0, 1 }, dc = {0, -1, 1, 0};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    DFS(grid, i , j);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        for(int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                DFS(grid, nr, nc);
            }
        }
    }
}
