class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> yetToArrive = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < tasks.length; i++) {
            yetToArrive.offer(new int[]{i, tasks[i][0], tasks[i][1]});
        }

        PriorityQueue<int[]> waiting = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[0], b[0]);
        });
        int[] list = new int[tasks.length];

        int time = 0, idx = 0;

        while(!yetToArrive.isEmpty() || !waiting.isEmpty()) {
            if (waiting.isEmpty()) {
                time = Math.max(time, yetToArrive.peek()[1]);
            }

            while (!yetToArrive.isEmpty() && yetToArrive.peek()[1] <= time) {
                waiting.offer(yetToArrive.poll());
            }

            int[] task = waiting.poll();
            time += task[2];
            list[idx++] = task[0];
        }

        return list;
    }
}