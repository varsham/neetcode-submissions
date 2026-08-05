class Solution {
    int ROWS, COLS;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0; // value to return
        // loop through each square to start dfs?
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                // only start dfs from the cells that are islands
                if (grid[r][c] == 1) {
                    area = Math.max(area, dfs(grid, r, c));
                } 
            }
        }

        return area;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) {
            return 0;
        }

        // if the current cell is valid, mark it as visited
        grid[r][c] = 0;
        int res = 1;
        for (int[] d : directions) {
            res += dfs(grid, r + d[0], c + d[1]);
        }

        return res;
    }
}
