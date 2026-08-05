class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] memo1 = new int[n - 1];
        int[] memo2 = new int[n - 1];

        memo1[0] = nums[0];
        memo1[1] = Math.max(nums[1], nums[0]);

        memo2[0] = nums[1];
        memo2[1] = Math.max(nums[2], nums[1]);

        for (int i = 2; i < n - 1; i++) {
            memo1[i] = Math.max(nums[i] + memo1[i - 2], memo1[i - 1]);
            memo2[i] = Math.max(nums[i + 1] + memo2[i - 2], memo2[i - 1]);
        }

        return Math.max(memo1[n - 2], memo2[n - 2]);
    }
}
