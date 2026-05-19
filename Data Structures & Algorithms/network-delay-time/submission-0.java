class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : times) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0], currentDistance = current[1];

            if (currentDistance > distance[currentNode]) continue;

            for (int[] edge: adj[currentNode]) {
                int neighbor = edge[0];
                int weight = edge[1];

                int newDistance = currentDistance + weight;

                if (newDistance < distance[neighbor]) {
                    distance[neighbor] = newDistance;
                    pq.offer(new int[]{neighbor, newDistance});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(distance[i], max);
        }

        return max;
    }
}
