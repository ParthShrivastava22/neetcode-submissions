class Solution {
    int perimeter;

    public int islandPerimeter(int[][] grid) {
        perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    dfs(grid, i, j);
                    return perimeter;
                }
            }
        }
        return perimeter;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (outOfBounds(grid, i, j) || grid[i][j] == 0) {
            perimeter++;
            return;
        }

        if (grid[i][j] == 2) return;

        grid[i][j] = 2;
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }

    private boolean outOfBounds(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}