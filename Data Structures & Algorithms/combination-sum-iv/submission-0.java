class Solution {
    Map<Integer, Integer> memo;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        memo.put(0, 1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if (memo.containsKey(target)) return memo.get(target);

        int res = 0;
        for (int num: nums) {
            if (target < num) break;
            res += dfs(nums, target - num);
        }

        memo.put(target, res);
        return res;
    }
}