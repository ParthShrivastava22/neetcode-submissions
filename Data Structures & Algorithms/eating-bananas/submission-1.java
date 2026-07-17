class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = piles.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(piles[i], max);
            min = Math.min(piles[i], min);
        }

        int left = 1, right = max;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int hours = hoursTaken(piles, mid);

            if (hours <= h) {
                right = mid - 1;
            } else left = mid + 1;
        }

        return left;
    }

    private int hoursTaken(int[] piles, int k) {
        int hours = 0;

        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / k;
            if (piles[i] % k != 0) {
                hours++;
            }
        }
        return hours;
    }
}
