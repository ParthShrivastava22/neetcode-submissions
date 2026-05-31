class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();

        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] course: prerequisites) {
            adjList[course[0]].add(course[1]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i, adjList, state, list)) {
                    int[] emptyList = new int[0];
                    return emptyList;
                }
            }
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    private boolean hasCycle(int node, List<Integer>[] adjList, int[] state, List<Integer>
                        list) {
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;

        state[node] = 1;

        for (int neighbour: adjList[node]) {
            if (hasCycle(neighbour, adjList, state, list)) return true;
        }

        list.add(node);
        state[node] = 2;

        return false;
    }
}
