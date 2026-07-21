class Solution {
    public boolean canJump(int[] nums) {
        int lastReachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (lastReachable >= i) {
                lastReachable = Math.max(lastReachable, i + nums[i]);
            }
            if (lastReachable >= nums.length - 1) return true;
        }

        return false;
    }
}
