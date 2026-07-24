class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        dfs(nums, powerSet, 0, new ArrayList<>());
        return powerSet;
    }

    private void dfs(int[] nums, List<List<Integer>> powerSet, int i, List<Integer> currentSet) {
        if (i >= nums.length) {
            powerSet.add(new ArrayList<>(currentSet));
            return;
        }

        dfs(nums, powerSet, i + 1, currentSet);
        currentSet.add(nums[i]);
        dfs(nums, powerSet, i + 1, currentSet);
        currentSet.remove(currentSet.size() - 1);
    }
}
