class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];

        int total = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) total += leftMax - height[left++];
            else total += rightMax - height[right--];
        }

        return total;
    }
}
