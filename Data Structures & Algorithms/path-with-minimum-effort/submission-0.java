class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        
        int[][] minEffort = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(minEffort[i], Integer.MAX_VALUE);
        }

        minEffort[0][0] = 0;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{0, 0, 0});

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ans = minEffort[row - 1][col - 1];
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            if (i == row - 1 && j == col - 1) {
                ans = curr[2];
                break;
            }

            for (int[] direction: directions) {
                int k = i + direction[0], l = j + direction[1];

                if (outOfBounds(heights, k, l)) continue;
                int newEffort = Math.max(curr[2],
                    Math.abs(heights[i][j] - heights[k][l]));
                if (minEffort[k][l] <= newEffort) continue;
                minEffort[k][l] = newEffort;

                queue.offer(new int[]{k, l, newEffort});
            }
        }

        return ans;
    }

    private boolean outOfBounds(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}