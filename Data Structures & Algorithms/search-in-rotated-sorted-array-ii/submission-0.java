class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            else if (nums[mid] > nums[right]) {
                if (nums[mid] >= target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                if (target <= nums[right] && target >= nums[mid]) left = mid + 1;
                else right = mid - 1;
            }
            else right--;
        }

        return false;
    }
}