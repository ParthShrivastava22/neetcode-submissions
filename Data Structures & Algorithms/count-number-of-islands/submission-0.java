class Solution {
    int totalIslands;

    public int numIslands(char[][] grid) {
        totalIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    totalIslands++;
                }
            }
        }

        return totalIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (outOfBounds(grid, i, j) || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private boolean outOfBounds(char[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
