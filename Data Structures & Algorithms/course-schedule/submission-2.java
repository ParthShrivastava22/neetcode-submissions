class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build Adjacency List using an Array of Lists
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] course : prerequisites) {
            adjList[course[0]].add(course[1]);
        }

        // 2. State Array (Defaults to 0 automatically in Java)
        // 0 = Unvisited, 1 = Visiting, 2 = Visited (Safe)
        int[] state = new int[numCourses];

        // 3. Initiate DFS for all unvisited nodes
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i, adjList, state)) {
                    return false; 
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<Integer>[] adjList, int[] state) {
        // Base Cases: Check memoized states
        if (state[node] == 1) return true;  // Caught in a cycle!
        if (state[node] == 2) return false; // Already verified safe

        // 1. Modify State (Mark as Visiting)
        state[node] = 1;

        // 2. Explore Neighbors (If the node has no neighbors, the loop safely skips)
        for (int neighbor : adjList[node]) {
            if (hasCycle(neighbor, adjList, state)) {
                return true;
            }
        }

        // 3. Revert/Finalize State (Mark as Visited/Safe)
        state[node] = 2;
        
        return false;
    }
}
