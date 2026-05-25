class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int level = 0;

        while(fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();

            for (int t = 0; t < length; t++) {
                int[] current = queue.poll();
                int i = current[0], j = current[1];

                for (int[] dir: directions) {
                    int k = i + dir[0], l = j + dir[1];

                    if (outOfBounds(grid, k, l) || grid[k][l] != 1) continue;

                    grid[k][l] = 2;
                    fresh--;
                    queue.offer(new int[]{k, l});
                }
            }
            level++;
        }

        return fresh == 0 ? level : -1;
    }

    private boolean outOfBounds(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
