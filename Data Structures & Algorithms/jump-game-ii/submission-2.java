class Solution {
    public int jump(int[] nums) {
        int currentInterval = 0, farthestReach = 0, jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthestReach = Math.max(farthestReach, i + nums[i]);

            if (i == currentInterval) {
                currentInterval = farthestReach;
                jumps++;
            }
        }

        return jumps;
    }
}
