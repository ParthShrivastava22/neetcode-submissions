class Solution {
    public int tribonacci(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                break;
        }
        int[] memo = new int[n + 1];

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] +  memo[i - 3];
        }

        return memo[n];
    }
}