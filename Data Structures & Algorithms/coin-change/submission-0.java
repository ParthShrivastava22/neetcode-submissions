class Solution {
    HashMap<Integer, Integer> memo;

    public int coinChange(int[] coins, int amount) {
        memo = new HashMap<>();
        int minCoins = dfs(coins, amount);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) return memo.get(amount);

        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amount - coin >= 0) {
                int result = dfs(coins, amount - coin);
                if (result != Integer.MAX_VALUE) min = Math.min(min, 1 + result);
            }
        }

        memo.put(amount, min);
        return min;
    }
}
