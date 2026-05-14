class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int curMax = 1, curMin = 1;

        for (int i = 0; i < nums.length; i++) {
            int oldMax = curMax;
            curMax = Math.max(nums[i], Math.max(nums[i] * curMax, nums[i] * curMin));
            curMin = Math.min(nums[i], Math.min(nums[i] * oldMax, nums[i] * curMin));
            max = Math.max(curMax, max);
        }

        return max;
    }
}
