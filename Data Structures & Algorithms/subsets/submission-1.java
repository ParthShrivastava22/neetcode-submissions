class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        dfs(nums, powerSet, 0, new ArrayList<>());
        return powerSet;
    }

    private void dfs(int[] nums, List<List<Integer>> powerSet, int i, List<Integer> currentSet) {
        if (i >= nums.length) return;

        dfs(nums, powerSet, i + 1, currentSet);
        List<Integer> newSet = new ArrayList<>(currentSet);
        newSet.add(nums[i]);
        powerSet.add(newSet);
        dfs(nums, powerSet, i + 1, newSet);
    }
}
