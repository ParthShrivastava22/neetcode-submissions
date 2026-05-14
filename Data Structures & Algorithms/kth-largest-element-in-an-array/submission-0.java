class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for (int num: nums) {
            p.add(num);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = p.poll();
        }

        return res;
    }
}
