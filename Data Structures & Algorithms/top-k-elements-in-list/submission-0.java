class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            answer[i] = queue.poll()[1];
        }

        return answer;
    }
}
