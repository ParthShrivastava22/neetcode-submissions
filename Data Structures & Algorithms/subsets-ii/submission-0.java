class Solution {
    Set<List<Integer>> sets;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        sets = new HashSet<>();
        List<Integer> currentSet = new ArrayList<>();
        sets.add(currentSet);
        addSet(currentSet, nums, 0);

        return new ArrayList<>(sets);
    }

    private void addSet(List<Integer> currentSet, int[] nums, int i) {
        if (i >= nums.length) return;

        List<Integer> newSet = new ArrayList<>(currentSet);
        addSet(newSet, nums, i + 1);
        newSet.add(nums[i]);
        sets.add(newSet);
        addSet(newSet, nums, i + 1);
    }
}
