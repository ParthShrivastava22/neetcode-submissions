class Solution {
    Set<List<Integer>> powerSet;

    public List<List<Integer>> subsets(int[] nums) {
       powerSet = new HashSet<>();
       List<Integer> currentSet = new ArrayList<>();
       powerSet.add(currentSet);
       addSet(currentSet, nums, 0);

       return new ArrayList<>(powerSet);
    }

    private void addSet(List<Integer> currentSet, int[] nums, int index) {
        if (index >= nums.length) return;

        List<Integer> newSet = new ArrayList<>(currentSet);
        addSet(newSet, nums, index + 1);
        newSet.add(nums[index]);
        powerSet.add(newSet);
        addSet(newSet, nums, index + 1);
    }
}
