class Solution {
    public int[] countBits(int n) {
        int[] memo = new int[n + 1];

        memo[0] = 0;
        int power = 1;

        for (int i = 1; i <= n; i++) {
            if (power * 2 == i) {
                power = i;
            }

            memo[i] = memo[i - power] + 1;
        }

        return memo;
    }
}
