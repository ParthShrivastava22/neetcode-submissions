class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> quad = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            long curTarget = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1, l = nums.length - 1;

                while(k < l) {
                    long total = (long) nums[j] + nums[k] + nums[l];

                    if (total - curTarget > 0) l--;
                    else if (total - curTarget < 0) k++;
                    else {
                        quad.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        do {
                            k++;
                        } while(k < l && nums[k] == nums[k - 1]);
                        do {
                            l--;
                        } while(k < l && nums[l] == nums[l + 1]);
                    }
                }
            }
        }

        return new ArrayList<>(quad);
    }
}