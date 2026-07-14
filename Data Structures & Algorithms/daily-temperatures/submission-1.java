class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;
        int[] result = new int[l];

        int[] stack = new int[l];
        int top = -1;

        for (int i = 0; i < l; i++) {
            while (top >= 0 && temperatures[stack[top]] < temperatures[i]) {
                result[stack[top]] = i - stack[top];
                top--;
            }

            stack[++top] = i;
        }

        for (int i = 0; i <= top; i++) {
            result[stack[i]] = 0;
        }

        return result;
    }
}
