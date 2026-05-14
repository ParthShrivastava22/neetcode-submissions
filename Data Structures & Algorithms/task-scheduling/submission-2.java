class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task: tasks) {
            freq[task - 'A']++;
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) queue.offer(new int[]{freq[i], i});
        }

        Queue<int[]> q2 = new ArrayDeque<>();
        int time = 0;

        while(!queue.isEmpty() || !q2.isEmpty()) {
            time++;

            if (!queue.isEmpty()) {
                int[] curr = queue.poll();
                curr[0]--;

                if (curr[0] > 0) {
                    q2.offer(new int[]{curr[0], curr[1], time + n});
                }
            }

            if (!q2.isEmpty() && q2.peek()[2] == time) {
                int[] add = q2.poll();
                queue.offer(new int[]{add[0], add[1]});
            }
        }

        return time;
    }
}
