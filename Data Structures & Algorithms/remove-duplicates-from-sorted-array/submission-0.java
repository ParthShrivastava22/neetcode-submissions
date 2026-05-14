class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, l = nums.length;

        for (int j = 0; j < l; j++) {
            if (j == 0 || nums[j] != nums[j - 1]) nums[i++] = nums[j];
        }

        return i;
    }
}