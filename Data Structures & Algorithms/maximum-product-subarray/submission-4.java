class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0], currentMin = nums[0], bestSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = currentMax;
            
            currentMax = Math.max(num, Math.max(currentMax * num, 
                        currentMin * num));
            currentMin = Math.min(num, Math.min(currentMin * num, 
                        tempMax * num));
            bestSoFar = Math.max(bestSoFar, currentMax);
        }

        return bestSoFar;
    }
}
