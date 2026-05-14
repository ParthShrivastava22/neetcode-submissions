class Solution {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            counts[i] = hammingWeight(i);
        }

        return counts;
    }

    private int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            n &= n - 1;
            count++;
        }

        return count;
    }
}
