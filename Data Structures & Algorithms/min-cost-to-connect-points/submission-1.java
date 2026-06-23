class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        
        // Queue stores: {node_index, edge_weight}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // Start at Node 0 with a cost of 0
        pq.offer(new int[]{0, 0});
        
        int totalCost = 0;
        int connectedNodes = 0;

        // Exit early if we've connected all N points
        while (!pq.isEmpty() && connectedNodes < n) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];

            // If we already connected this point, skip it (prevents cycles)
            if (visited[node]) continue;

            // 1. Pave the road!
            visited[node] = true;
            totalCost += dist;
            connectedNodes++;

            // 2. Evaluate all possible next roads from this newly connected point
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int nextDist = Math.abs(points[node][0] - points[i][0]) + 
                                   Math.abs(points[node][1] - points[i][1]);
                    pq.offer(new int[]{i, nextDist});
                }
            }
        }

        return totalCost;
    }
}