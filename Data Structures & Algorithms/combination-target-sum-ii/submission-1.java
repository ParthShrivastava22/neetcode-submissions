class Solution {
    Set<List<Integer>> combinations;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinations = new HashSet<>();
        combination(new ArrayList<>(), candidates, 0, target, 0);
        return new ArrayList<>(combinations);
    }

    private void combination(List<Integer> curr, int[] candidates, int sum, int target, 
                                int i) {
        if (sum == target) combinations.add(new ArrayList<>(curr)); 
        if (i >= candidates.length || sum >= target) return;

        sum += candidates[i];
        curr.add(candidates[i]);
        combination(curr, candidates, sum, target, i + 1);

        sum -= candidates[i];
        curr.remove(curr.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        combination(curr, candidates, sum, target, i + 1);
    }
}
