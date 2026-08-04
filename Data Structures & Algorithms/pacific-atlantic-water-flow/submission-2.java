class Solution {
    int ROWS, COLS;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        // populate the source queues
        for (int c = 0; c < COLS; c++) {
            pacQueue.add(new int[]{0, c});
            atlQueue.add(new int[]{ROWS - 1, c});
        }

        for (int r = 0; r < ROWS; r++) {
            pacQueue.add(new int[]{r, 0});
            atlQueue.add(new int[]{r, COLS - 1});
        }
        
        // run bfs on each
        bfs(pacQueue, heights, pac);
        bfs(atlQueue, heights, atl);

        List<List<Integer>> result = new ArrayList<>();

        // check each result
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) result.add(Arrays.asList(r, c));
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> q, int[][] heights, boolean[][] ocean) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;

            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}