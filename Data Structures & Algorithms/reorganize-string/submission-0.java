class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int max = 0;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            max = Math.max(max, count[c - 'a']);
        }

        if (max > (s.length() + 1) / 2) return "";

        Queue<int[]> priority = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) priority.offer(new int[]{count[i], i});
        }

        int[] waiting = null;
        StringBuilder builder = new StringBuilder();

        while(!priority.isEmpty()) {
            int[] current = priority.poll();
            current[0]--;
            builder.append((char) (current[1] + 'a'));

            if (waiting != null) {
                priority.offer(waiting);
                waiting = null;
            }

            if (current[0] > 0) {
                waiting = current;
            }
        }

        return builder.toString();
    }
}