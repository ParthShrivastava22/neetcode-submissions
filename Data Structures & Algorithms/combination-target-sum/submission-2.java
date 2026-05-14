class Solution {
    Set<List<Integer>> combinations;
    int[] numList;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinations = new HashSet<>();
        numList = nums;
        findSum(new ArrayList<>(), 0, target, 0);
        return new ArrayList<>(combinations);
    }

    private void findSum(List<Integer> curr, int total, int target, int index) {
        if (index >= numList.length) return;

        if (total == target) combinations.add(new ArrayList<>(curr));
        if (total >= target) return;

        curr.add(numList[index]);
        findSum(curr, total + numList[index], target, index);
        curr.remove(curr.size() - 1);
        findSum(curr, total, target, index + 1);
    }
}
