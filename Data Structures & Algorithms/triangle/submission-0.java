class Solution {
    int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][];
        int INF = Integer.MAX_VALUE;
        for (int r = 0; r < triangle.size(); r++) {
            memo[r] = new int[triangle.get(r).size()];
            Arrays.fill(memo[r], INF);
        }
        return total(triangle, 0, 0);
    }

    private int total(List<List<Integer>> triangle, int row, int i) {
        if (row >= triangle.size()) return 0;
        if (memo[row][i] != Integer.MAX_VALUE) return memo[row][i];

        int a = triangle.get(row).get(i);

        memo[row][i] = Math.min(total(triangle, row + 1, i), total(triangle, row + 1, i + 1))
                + a;
        return memo[row][i];
    }
}