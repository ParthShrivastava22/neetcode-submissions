class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            heap.offer(stones[i]);
        }

        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();

            if (a - b != 0) heap.offer(a - b);
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }
}
