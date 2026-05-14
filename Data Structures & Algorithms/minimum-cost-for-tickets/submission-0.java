public class Solution {
    private int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return dfs(0, days.length, days, costs);
    }

    private int dfs(int i, int n, int[] days, int[] costs) {
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];

        int res = costs[0] + dfs(i + 1, n, days, costs);
        int j = i;
        while (j < n && days[j] < days[i] + 7) {
            j++;
        }
        res = Math.min(res, costs[1] + dfs(j, n, days, costs));

        j = i;
        while (j < n && days[j] < days[i] + 30) {
            j++;
        }
        res = Math.min(res, costs[2] + dfs(j, n, days, costs));

        dp[i] = res;
        return res;
    }
}