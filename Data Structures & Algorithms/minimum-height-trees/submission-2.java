class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> empty = new ArrayList<>();
            empty.add(0);
            return empty;
        }
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge: edges) {
            int node = edge[0], neighbor = edge[1];

            if (!adjList.containsKey(node)) adjList.put(node, new ArrayList<>());
            adjList.get(node).add(neighbor);

            if (!adjList.containsKey(neighbor)) adjList.put(neighbor, new ArrayList<>());
            adjList.get(neighbor).add(node);
        }

        int[] minHeight = new int[n];
        boolean[] visited = new boolean[n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minHeight[i] = dfs(i, adjList, visited);
            min = Math.min(min, minHeight[i]);
        }

        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (minHeight[i] == min) finalList.add(i);
        }

        return finalList;
    }

    private int dfs(int i, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        List<Integer> list = adjList.get(i);
        visited[i] = true;
        
        int maxHeight = Integer.MIN_VALUE;
        for (int nei: list) {
            if (visited[nei]) continue;
            maxHeight = Math.max(maxHeight, 1 + dfs(nei, adjList, visited));
        }
        visited[i] = false;

        return maxHeight == Integer.MIN_VALUE ? 0 : maxHeight;
    }
}