class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] course: prerequisites) {
            if (adjList.containsKey(course[0])) adjList.get(course[0]).add(course[1]);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(course[1]);
                adjList.put(course[0], list);
            }
        }

        Map<Integer, Integer> state = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            state.put(i, 0);
        }

        for (int i = 0; i < numCourses; i++) {
            if (state.get(i) == 0) {
                if (formCycle(prerequisites, state, i, adjList)) return false;
            }
        }

        return true;
    }

    private boolean formCycle(int[][] prerequisites, Map<Integer, Integer> state, 
                                int i, Map<Integer, List<Integer>> adjList) {
        if (state.get(i) == 1) return true;
        if (state.get(i) == 2) return false;
        if (!adjList.containsKey(i)) {
            state.put(i, 2);
            return false;
        }

        state.put(i, 1);
        List<Integer> list = adjList.get(i);
        for (int course: list) {
            if (formCycle(prerequisites, state, course, adjList)) return true;
        }
        state.put(i, 2);

        return false;
    }
}
