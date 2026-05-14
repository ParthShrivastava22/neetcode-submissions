class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) return false;
        int reqSum = totalSum / 2;

        return sumExists(nums, 0, reqSum);
    }

    private boolean sumExists(int[] nums, int i, int target) {
        if (i == nums.length) return false;

        if (nums[i] - target == 0) return true;

        else return sumExists(nums, i + 1, target) || sumExists(nums, i + 1,
         target - nums[i]); 
    }
}
