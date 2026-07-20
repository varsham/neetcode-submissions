class Solution {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        // loop through the cells
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int r, int c) {
        // check the current cell
        // write the exit condition
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // set the current value to visited
        grid[r][c] = '0';
        // do depth first search in all the directions
        for (int[] d : directions) {
            dfs(grid, r + d[0], c + d[1]);
        }


    }
}

