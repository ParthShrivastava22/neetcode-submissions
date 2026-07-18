class Solution {
    public int search(int[] nums, int target) {
        boolean rotated = true;
        if (nums[0] < nums[nums.length - 1] || nums.length == 1) rotated = false;

        int left = 0, right = nums.length - 1;

        while (left <= right && rotated) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] < nums[0]) right = mid - 1;
            else left = mid + 1;
        }

        if (target == nums[left]) return left;

        int l, r;
        if (!rotated) {
            l = 0;
            r = nums.length - 1;
        } else {
            if (target <= nums[nums.length - 1]) {
                l = left + 1;
                r = nums.length - 1;
            } else {
                l = 0;
                r = left - 1;
            }
        }

        while (l <= r) {
            int m = (r - l) / 2 + l;

            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }
}
