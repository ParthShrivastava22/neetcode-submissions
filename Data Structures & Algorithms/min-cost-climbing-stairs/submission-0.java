class Solution {
    int[] minCosts;
    public int minCostClimbingStairs(int[] cost) {
        minCosts = new int[cost.length];
        for (int i = 0; i < minCosts.length; i++) {
            minCosts[i] = -1;
        }
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        if (i >= cost.length) return 0;

        if (minCosts[i] != -1) return minCosts[i];

        return minCosts[i] = cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
    }
}
