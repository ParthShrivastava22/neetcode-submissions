class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

        int total = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            int waterHeight = 0;

            if (leftMax < rightMax) waterHeight = leftMax - height[left++];
            else waterHeight = rightMax - height[right--];

            total += waterHeight;
        }

        return total;
    }
}
