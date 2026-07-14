class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int l = position.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        int[] stack = new int[l];
        int top = -1;

        for (int i = 0; i < l; i++) {
            while (top >= 0 && map.get(stack[top]) > map.get(position[i])) {
                double time1 = (target - position[i]) * 1.0 / map.get(position[i]);
                double time2 = (target - stack[top]) * 1.0 / map.get(stack[top]);

                if (time2 <= time1) top--;
                else break;
            }

            stack[++top] = position[i];
        }

        return top + 1;
    }
}
