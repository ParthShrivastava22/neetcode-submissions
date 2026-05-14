class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Queue<int[]> arrival = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] trip: trips) {
            arrival.offer(trip);
        }

        Queue<int[]> departure = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int currentSpace = capacity, distance = 0;

        while(!arrival.isEmpty()) {
            distance++;
            while(!departure.isEmpty() && departure.peek()[2] == distance) {
                int[] current = departure.poll();
                currentSpace += current[0];
            }

            while(!arrival.isEmpty() && arrival.peek()[1] == distance) {
                int[] current = arrival.poll();
                if (current[0] > currentSpace) return false;
                currentSpace -= current[0];
                departure.offer(current);
            }
        }

        return true;
    }
}