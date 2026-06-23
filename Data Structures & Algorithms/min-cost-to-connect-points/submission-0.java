class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> unvisited = new HashSet<>();

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[] cost = new int[points.length];

        for (int i = 1; i < points.length; i++) {
            unvisited.add(i);
            int dist = Math.abs(points[0][0] - points[i][0]) + 
                Math.abs(points[0][1] - points[i][1]);
            queue.add(new int[]{0, i, dist});
            cost[i] = Integer.MAX_VALUE;
        }
        visited.add(0);
        cost[0] = 0;

        while(!unvisited.isEmpty()) {
            int[] curr = queue.poll();
            int start = curr[0], end = curr[1], dist = curr[2];

            if (visited.contains(end)) continue;
            cost[end] = Math.abs(points[start][0] - points[end][0]) + 
                Math.abs(points[start][1] - points[end][1]);
            unvisited.remove(end);
            visited.add(end);

            for (int i = 1; i < points.length; i++) {
                if (i == end || visited.contains(i)) continue;

                int d = Math.abs(points[end][0] - points[i][0]) + 
                Math.abs(points[end][1] - points[i][1]);
                queue.offer(new int[]{end, i, d});
            }
        }

        int total = 0;
        for (int i = 1; i < points.length; i++) {
            total += cost[i];
        }

        return total;
    }
}
