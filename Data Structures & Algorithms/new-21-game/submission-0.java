class Solution {
    double[] dp;
    public double new21Game(int n, int k, int maxPts) {
        dp = new double[k];
        Arrays.fill(dp, -1);
        return dfs(0, n, k, maxPts);
    }

    private double dfs(int score, int n, int k, int maxPts) {
        if (score >= k) {
            return (score > n) ? 0 : 1;
        }

        if (dp[score] != -1) return dp[score];

        double res = 0;
        for (int i = 1; i <= maxPts; i++) {
            res += dfs(score + i, n, k, maxPts);
        }

        dp[score] = res / maxPts;
        return dp[score];
    }
}