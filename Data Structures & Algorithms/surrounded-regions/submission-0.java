class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] reachable = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, reachable, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, reachable, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, reachable, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, reachable, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !reachable[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] reachable, int i, int j) {
        if (reachable[i][j]) return;

        reachable[i][j] = true;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int[] dir: directions) {
            int a = dir[0], b = dir[1];
            if (!outOfBounds(board, i + a, j + b) && board[i + a][j + b] == 'O') {
                dfs(board, reachable, i + a, j + b);
            }
        }
    }

    private boolean outOfBounds(char[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
