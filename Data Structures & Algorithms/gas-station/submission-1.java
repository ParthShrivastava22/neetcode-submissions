class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int candidate = 0;
        int net = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            tank = tank - cost[i] + gas[i];
            if (tank < 0) {
                candidate = i + 1;
                tank = 0;
            }

            net = net + gas[i] - cost[i];
        }

        return (net < 0) ? -1 : candidate;
    }
}
