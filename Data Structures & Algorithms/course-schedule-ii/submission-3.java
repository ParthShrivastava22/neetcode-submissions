class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] list = new int[numCourses];
        int head = -1;

        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] indegrees = new int[numCourses];
        for (int[] course: prerequisites) {
            adjList[course[1]].add(course[0]);
            indegrees[course[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int processedCourses = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                list[++head] = i;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCourses++;
            for (int i: adjList[current]) {
                indegrees[i]--;
                if (indegrees[i] == 0) {
                    queue.offer(i);
                    list[++head] = i;
                }
            }
        }

        return (processedCourses == numCourses) ? list : new int[0];
    }
}
