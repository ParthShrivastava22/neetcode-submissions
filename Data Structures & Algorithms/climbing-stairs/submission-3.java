class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n -1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            memo[i] = memo[i + 1] + memo[i + 2];
        }

        return memo[0];
    }
}