class Solution {
    List<List<Integer>> subsets;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets = new ArrayList<>();
        addSubset(new ArrayList<>(), nums, 0);
        return subsets;
    }

    private void addSubset(List<Integer> currentSet, int[] nums, int i) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(currentSet));
            return;
        }

        currentSet.add(nums[i]);
        addSubset(currentSet, nums, i + 1);

        currentSet.remove(currentSet.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        addSubset(currentSet, nums, i + 1);
    }
}
