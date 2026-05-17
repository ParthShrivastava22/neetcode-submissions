class Solution {
        Set<List<Integer>> list;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        list = new HashSet<>();
        boolean[] visited = new boolean[nums.length]; 
        addToList(new ArrayList<>(), visited, nums);

        return new ArrayList<>(list);  
    }

    private void addToList(List<Integer> perms, boolean[] visited, int[] nums) {
        if (perms.size() == nums.length) {
            list.add(new ArrayList<>(perms));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue; 
            }

            perms.add(nums[i]);
            visited[i] = true;
            addToList(perms, visited, nums);

            perms.remove(perms.size() - 1);
            visited[i] = false;
        }
    }
}