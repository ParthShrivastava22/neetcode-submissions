class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] course: prerequisites) {
            adjList[course[0]].add(course[1]);
        }

        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Run BFS exactly once per node to map out everything it can reach
        for (int i = 0; i < numCourses; i++) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);

            while (!q.isEmpty()) {
                int current = q.poll();

                for (int nei : adjList[current]) {
                    // This acts as BOTH our state modification (visited set) 
                    // AND our final answer cache.
                    if (!reachable[i][nei]) {
                        reachable[i][nei] = true;
                        q.offer(nei);
                    }
                }
            }
        }

        // 3. Answer Queries in O(1) Time
        List<Boolean> list = new ArrayList<>();
        for (int[] query : queries) {
            // Because we precomputed everything, we just look up the coordinates
            list.add(reachable[query[0]][query[1]]);
        }

        return list;
    }
}