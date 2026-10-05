class Solution {
    int[] r = {-1, 1, 0, 0};
    int[] c = {0, 0, -1, 1};
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][cols - 1] == 'O') dfs(i, cols - 1, board);
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);
            if (board[rows - 1][j] == 'O') dfs(rows - 1, j, board);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Captured
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // Restored
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board) {
        board[row][col] = '#'; 
        for (int i = 0; i < 4; i++) {
            int newr = row + r[i];
            int newc = col + c[i];
            if (newr >= 0 && newr < board.length && newc >= 0 && newc < board[0].length && board[newr][newc] == 'O') {
                dfs(newr, newc, board);
            }
        }
    }
}
