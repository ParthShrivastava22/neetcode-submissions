class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);

        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
