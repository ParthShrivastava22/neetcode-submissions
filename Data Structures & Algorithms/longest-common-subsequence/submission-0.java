class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int[] entry: memo) {
            Arrays.fill(entry, -1);
        }
        return dfs(text1, text2, 0, 0, memo);
    }

    private int dfs(String text1, String text2, int i, int j, int[][] memo) {
        if (i >= text1.length() || j >= text2.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int longest = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            longest = 1 + dfs(text1, text2, i + 1, j + 1, memo);
        }

        longest = Math.max(longest, Math.max(dfs(text1, text2, i + 1, j, memo),        dfs(text1, text2, i, j + 1, memo)));
        
        memo[i][j] = longest;
        return longest;
    }
}
