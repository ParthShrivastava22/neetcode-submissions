class Solution {
    Map<Integer, Integer> map;
    public int numSquares(int n) {
        map = new HashMap<>();
        map.put(0, 0);
        return dfs(n);
    }

    private int dfs(int n) {
        if (map.containsKey(n)) return map.get(n);

        int res = n;

        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, 1 + dfs(n -  i * i));
        }
        map.put(n, res);
        return res;
    }
}