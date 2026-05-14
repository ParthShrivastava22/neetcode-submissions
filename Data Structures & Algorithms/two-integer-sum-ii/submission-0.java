class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] indexes = {-1, -1};
        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                indexes[0] = l + 1;
                indexes[1] = r + 1;
                break;
            }
            else if (sum > target) {
                r--;
            }
            else {
                l++;
            }
        }
        return indexes;
    }
}
