class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int total = a + b + c, max = Math.max(a, Math.max(b, c));
        if (total == max) return "";

        int[] count = new int[]{a, b, c};
        Queue<int[]> priority = new PriorityQueue<>((k, l) -> l[0] - k[0]);
        for (int i = 0; i < 3; i++) {
            if (count[i] > 0) priority.add(new int[]{count[i], i});
        }

        int[] waiting = null;
        StringBuilder builder = new StringBuilder();
        int previous = -1;

        while(!priority.isEmpty()) {
            int[] current = priority.poll();
            builder.append((char) (current[1] + 'a'));
            current[0]--;

            if (waiting != null) {
                priority.offer(waiting);
                waiting = null;
            }

            if (current[0] > 0) {
                if (previous == current[1]) waiting = current;
                else priority.offer(current);
            }

            previous = current[1];
        }

        return builder.toString();
    }
}