class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0], maxSum = nums[0], minSum = nums[0];
        int currentMax = nums[0], currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > currentMax + num) currentMax = num;
            else currentMax += num;
            maxSum = Math.max(maxSum, currentMax);

            if (num < currentMin + num) currentMin = num;
            else currentMin += num;
            minSum = Math.min(minSum, currentMin);

            total += num;
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}