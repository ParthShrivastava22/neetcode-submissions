class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1] || nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] < nums[0]) right = mid - 1;
            else left = mid + 1;
        }

        return nums[left];
    }
}
