class Solution {
    
    public boolean exist(char[][] board, String word) {
        // possibilities at each index:
        // up, down, left, right

        List<Character> cur = new ArrayList<>();
        char[][] visited = new char[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    cur.add(board[r][c]);
                    visited[r][c] = 1;
                    
                    if (backtrack(cur, board, visited, word, r, c, 1)) return true;
                    
                    // Reset single tile state properly if this starting cell fails
                    visited[r][c] = 0;
                    cur.clear();
                }
            }
        }

        return false;
        
    }

    public boolean backtrack(List<Character> cur, char[][] board, char[][] visited, String word, int r, int c, int i) {
        if (cur.size() == word.length()) return true;

        // at each index, different possibilities
        // check for up
        if (r + 1 < board.length && visited[r + 1][c] == 0 && word.charAt(i) == board[r + 1][c]) {
            cur.add(board[r + 1][c]);
            visited[r + 1][c] = 1;
            if (backtrack(cur, board, visited, word, r + 1, c, i + 1)) return true;
            visited[r + 1][c] = 0;
            cur.remove(cur.size() - 1);
        }
        
        if (c + 1 < board[0].length && visited[r][c + 1] == 0 && word.charAt(i) == board[r][c + 1]) {
            cur.add(board[r][c + 1]);
            visited[r][c + 1] = 1;
            if (backtrack(cur, board, visited, word, r, c + 1, i + 1)) return true;
            visited[r][c + 1] = 0;
            cur.remove(cur.size() - 1);
        }

        if (r - 1 >= 0 && visited[r - 1][c] == 0 && word.charAt(i) == board[r - 1][c]) {
            cur.add(board[r - 1][c]);
            visited[r - 1][c] = 1;
            if (backtrack(cur, board, visited, word, r - 1, c, i + 1)) return true;
            visited[r - 1][c] = 0;
            cur.remove(cur.size() - 1);
        }

        if (c - 1 >= 0 && visited[r][c - 1] == 0 && word.charAt(i) == board[r][c - 1]) {
            cur.add(board[r][c - 1]);
            visited[r][c - 1] = 1;
            if (backtrack(cur, board, visited, word, r, c - 1, i + 1)) return true;
            visited[r][c - 1] = 0;
            cur.remove(cur.size() - 1);
        }

        return false;
    }
}
