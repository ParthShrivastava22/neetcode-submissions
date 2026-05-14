class Solution {
    int[] max;
    public int rob(int[] nums) {
        max = new int[nums.length];
        Arrays.fill(max, -1);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) return 0;

        if (max[i] != -1) return max[i];

        return max[i] = Math.max(nums[i] + dfs(nums, i + 2), dfs(nums, i + 1));
    }
}
