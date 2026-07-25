class Solution {
    List<List<Integer>> perms;

    public List<List<Integer>> permute(int[] nums) {
        perms = new ArrayList<>();
        boolean[] chosen = new boolean[nums.length];
        addToList(new ArrayList<>(), nums, chosen);
        return new ArrayList<>(perms);
    }

    private void addToList(List<Integer> list, int[] nums, boolean[] chosen) {
        if (list.size() == nums.length) {
            perms.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (chosen[i]) continue;

            list.add(nums[i]);
            chosen[i] = true;
            addToList(list, nums, chosen);
            list.remove(list.size() - 1);
            chosen[i] = false;
        }
    }
}
