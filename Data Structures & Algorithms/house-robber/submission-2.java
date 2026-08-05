class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] memo = new int[n];

        memo[n - 1] = nums[n - 1];
        memo[n - 2] = Math.max(nums[n - 2], nums[n - 1]);

        for (int i = n - 3; i >= 0; i--) {
            memo[i] = Math.max(nums[i] + memo[i + 2], memo[i + 1]);
        }

        return Math.max(memo[0], memo[1]);
    }
}
