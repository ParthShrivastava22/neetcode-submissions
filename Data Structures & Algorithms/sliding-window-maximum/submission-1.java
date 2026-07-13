class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.pollLast();
            queue.offer(nums[i]);
        }

        int n = nums.length;
        int[] windowMax = new int[n - k + 1];

        for (int i = k; i < n; i++) {
            int prevMax = queue.peek();
            windowMax[i - k] = prevMax;

            if (prevMax == nums[i - k]) queue.poll();

            while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.pollLast();
            queue.offer(nums[i]);
        }

        windowMax[n - k] = queue.poll();

        return windowMax;
    }
}
