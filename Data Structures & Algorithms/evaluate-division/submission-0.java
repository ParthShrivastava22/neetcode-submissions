class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adjMap = new HashMap<>();
        int n = values.length;

        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);

            if (!adjMap.containsKey(a)) adjMap.put(a, new HashMap<>());
            if (!adjMap.containsKey(b)) adjMap.put(b, new HashMap<>());

            adjMap.get(a).put(b, values[i]);
            adjMap.get(b).put(a, 1 / values[i]);
        }

        double[] results = new double[queries.size()];

        int i = 0;
        for (List<String> query: queries) {
            results[i++] = dfs(adjMap, query.get(0), query.get(1), new HashSet<>());
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> adjMap, String a, String b, Set<String> visited) {
            if (!adjMap.containsKey(a)) return -1;

            Map<String, Double> adjList = adjMap.get(a);
            if (adjList.containsKey(b)) return adjList.get(b);

            visited.add(a);

            for (Map.Entry<String, Double> entry: adjList.entrySet()) {
                if (visited.contains(entry.getKey())) continue;

                double val = dfs(adjMap, entry.getKey(), b, visited);
                if (val == -1) continue;

                return val * entry.getValue();
            }

            return -1;
    }
}