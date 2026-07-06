class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, maxProfit = 0, l = prices.length;

        for (int j = 0; j < l; j++) {
            int currentProfit = prices[j] - prices[i];

            if (currentProfit < 0) {
                i = j;
                continue;
            }

            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}
