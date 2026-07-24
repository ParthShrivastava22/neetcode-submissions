class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task: tasks) {
            freq[task - 'A']++;
        }

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
            return Integer.compare(b[1], a[1]);
        });

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) maxHeap.offer(new int[]{freq[i], i});
        }

        Deque<int[]> waiting = new ArrayDeque<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !waiting.isEmpty()) {
            while(!waiting.isEmpty()) {
                int[] curr = waiting.peekFirst();
                if (curr[0] <= time) {
                    int index = curr[1];
                    maxHeap.offer(new int[]{freq[index], index});
                    waiting.pollFirst();
                } else break;
            }

            if (!maxHeap.isEmpty()) {
                int[] task = maxHeap.poll();
                freq[task[1]]--;

                if (freq[task[1]] != 0) {
                    waiting.offer(new int[]{time + n + 1, task[1]});
                }
            }
            time++;
        }

        return time;
    }
}
