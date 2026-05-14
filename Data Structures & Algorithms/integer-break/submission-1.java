class Solution {
    Map<Integer, Integer> memo;

    public int integerBreak(int n) {
        memo = new HashMap<>();
        memo.put(1, 1);
        return dfs(n, n);
    }

    private int dfs(int n, int original) {
        if (memo.containsKey(n)) return memo.get(n);

        int res = original == n ? 0 : n;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dfs(i, original) * dfs(n - i, original));
        }

        memo.put(n, res);
        return res;
    }
}