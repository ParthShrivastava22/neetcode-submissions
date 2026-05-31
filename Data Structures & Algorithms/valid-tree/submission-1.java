class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{0, -1});
        visited.add(0);

        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0], parent = pair[1];

            for (int neighbor: adj.get(node)) {
                if (neighbor == parent) continue;
                if (visited.contains(neighbor)) return false;

                queue.offer(new int[]{neighbor, node});
                visited.add(neighbor);
            }
        }

        return visited.size() == n;
    }
}
