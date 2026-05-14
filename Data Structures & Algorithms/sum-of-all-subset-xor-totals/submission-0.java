class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        sum = 0;
        doXOR(nums, 0, 0);
        return sum;
    }

    private void doXOR(int[] nums, int index, int currXOR) {
        if (index >= nums.length) return;

        currXOR ^= nums[index];
        sum += currXOR;
        doXOR(nums, index + 1, currXOR);
        currXOR ^= nums[index];
        doXOR(nums, index + 1, currXOR);
    }
}