class Solution {
    Set<List<Integer>> combinations;
    int[] numList;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinations = new HashSet<>();
        numList = nums;
        List<Integer> curr = new ArrayList<>();
        findSum(curr, 0, target, 0);

        return new ArrayList<>(combinations);
    }

    private void findSum(List<Integer> curr, int total, int target, int index) {
        if (index >= numList.length) return;

        if (total == target) combinations.add(curr);
        if (total >= target) return;

        List<Integer> newList = new ArrayList<>(curr);
        findSum(newList, total, target, index + 1);
        newList.add(numList[index]);
        findSum(newList, total + numList[index], target, index + 1);
        findSum(newList, total + numList[index], target, index);
    }
}
