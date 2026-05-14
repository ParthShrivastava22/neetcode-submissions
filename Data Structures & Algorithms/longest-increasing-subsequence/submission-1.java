class Solution {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return longestSubsequence(nums, 0, -1);
    }

    private int longestSubsequence(int[] nums, int i, int j) {
        if (i == nums.length) return 0;
        if (memo[i][j + 1] != -1) return memo[i][j + 1];

        int longest = longestSubsequence(nums, i + 1, j);

        if (j == -1 || nums[i] > nums[j]) {
            longest = Math.max(longest, 1 + longestSubsequence(nums, i + 1, i));
        }

        memo[i][j + 1] = longest;
        return longest;
    }
}
