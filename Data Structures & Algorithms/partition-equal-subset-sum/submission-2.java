class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) return false;
        int reqSum = totalSum / 2;
        memo = new Boolean[nums.length][reqSum + 1];

        return sumExists(nums, 0, reqSum);
    }

    private boolean sumExists(int[] nums, int i, int target) {
        if (i == nums.length) return false;
        if (target < 0) return false;
        if (nums[i] - target == 0) return true;

        if (memo[i][target] != null) return memo[i][target];

        return memo[i][target] = sumExists(nums, i + 1, target) ||
         sumExists(nums, i + 1, target - nums[i]); 
    }
}
