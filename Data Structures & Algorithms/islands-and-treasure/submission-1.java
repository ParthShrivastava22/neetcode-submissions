class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0], j = current[1];

            for (int[] direction: directions) {
                int k = i + direction[0];
                int l = j + direction[1];

                if (outOfBounds(grid, k, l) || grid[k][l] != Integer.MAX_VALUE) continue;

                grid[k][l] = grid[i][j] + 1;
                queue.offer(new int[]{k, l});
            }
        }
    }

    private boolean outOfBounds(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
