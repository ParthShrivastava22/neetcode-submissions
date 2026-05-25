class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(i);
                    newList.add(j);
                    list.add(newList);
                }
            }
        }

        return list;
    }

    private void dfs(int[][] heights, boolean[][] sea, int i, int j) {
        if (sea[i][j] == true) return;

        sea[i][j] = true;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] dir: directions) {
            int a = dir[0], b = dir[1];
            if (!outOfBounds(heights, i + a, j + b) && 
                heights[i + a][j + b] >= heights[i][j]) {
                dfs(heights, sea, i + a, j + b);
            }
        }
    }

    private boolean outOfBounds(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
