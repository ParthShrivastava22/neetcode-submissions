class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int maxArea = 0;

        while(i < j) {
            int currentArea = (j - i) * Math.min(heights[i], heights[j]);

            maxArea = Math.max(currentArea, maxArea);
            if (heights[i] < heights[j]) i++;
            else j--;
        }

        return maxArea;
    }
}
