class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0], l = nums.length;

        for (int i = 1; i < l; i++) {
            if (currentSum + nums[i] < nums[i]) {
                currentSum = nums[i];
            }
            else {
                currentSum += nums[i];
            }

            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
