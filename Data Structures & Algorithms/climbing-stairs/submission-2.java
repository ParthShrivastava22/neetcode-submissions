class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n, 0, memo);
    }

    private int dfs(int n, int i, int[] memo) {
        if (i == n) return 1;
        if (i > n) return 0;

        if (memo[i] != -1) return memo[i];

        int ways = dfs(n, i + 1, memo) + dfs(n, i + 2, memo);
        memo[i] = ways;

        return ways;
    }
}
