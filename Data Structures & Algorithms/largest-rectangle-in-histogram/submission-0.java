class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int j = stack.pop();
                int width = (!stack.isEmpty()) ? i - 1 - stack.peek() :
                i;

                int area = heights[j] * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int j = stack.pop();
            int width = (!stack.isEmpty()) ? heights.length - stack.peek() - 1 : 
            heights.length;

            int area = heights[j] * width;
            maxArea = Math.max(maxArea, area);           
        }

        return maxArea;
    }
}
