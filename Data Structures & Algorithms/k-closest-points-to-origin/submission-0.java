class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> minDistance = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Double.compare(a[0], b[0]);
                return Double.compare(a[1], b[1]);
            }
        );

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            double distance = Math.sqrt(x * x + y * y);

            minDistance.offer(new double[]{distance, i});
        }

        int[][] list = new int[k][2];

        for (int i = 0; i < k; i++) {
            int index = (int) minDistance.poll()[1];
            list[i] = points[index];
        }

        return list;
    }
}
