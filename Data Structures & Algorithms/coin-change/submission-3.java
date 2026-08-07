class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[amount + 1][coins.length];

        // -1 means "not computed"
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int ans = dfs(memo, coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int[][] memo, int[] coins, int amount, int i) {
        if (amount == 0) return 0;
        if (i == coins.length) return Integer.MAX_VALUE;

        if (memo[amount][i] != -1) {
            return memo[amount][i];
        }

        // Skip current coin
        int ans = dfs(memo, coins, amount, i + 1);

        // Take current coin
        if (coins[i] <= amount) {
            int take = dfs(memo, coins, amount - coins[i], i);

            if (take != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + take);
            }
        }

        memo[amount][i] = ans;
        return ans;
    }
}
