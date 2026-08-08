class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[2][n];

        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return dfs(prices, memo, 0, false);
    }

    private int dfs(int[] prices, int[][] memo, int i, boolean holding) {
        if (holding) {
            if (i >= prices.length) return 0;

            if (memo[0][i] == Integer.MIN_VALUE) {
                int sellNowProfit = prices[i] + dfs(prices, memo, i + 2, false);
                int sellLaterProfit = dfs(prices, memo, i + 1, true);

                memo[0][i] = Math.max(sellNowProfit, sellLaterProfit);
            }

            return memo[0][i]; 
        } else {
            if (i >= prices.length) return 0;

            if (memo[1][i] == Integer.MIN_VALUE) {
                int buyNowProfit = dfs(prices, memo, i + 1, true) - prices[i];
                int buyLaterProfit = dfs(prices, memo, i + 1, false);

                memo[1][i] = Math.max(buyNowProfit, buyLaterProfit);
            }

            return memo[1][i];
        }
    }
}
