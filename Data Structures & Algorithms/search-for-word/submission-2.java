class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        List<Character> cur = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (backtrack(board, visited, cur, word, r, c, 0)) return true;
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, int[][] visited, List<Character> cur, String word, int r, int c, int i) {
        if (i == word.length()) return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(i) || visited[r][c] == 1) {
            return false;
        }

        // otherwise:
        visited[r][c] = 1;
        boolean result =
            backtrack(board, visited, cur, word, r + 1, c, i + 1) || 
            backtrack(board, visited, cur, word, r - 1, c, i + 1) ||
            backtrack(board, visited, cur, word, r, c + 1, i + 1) || 
            backtrack(board, visited, cur, word, r, c - 1, i + 1);
        visited[r][c] = 0;

        return result;
    }
}
