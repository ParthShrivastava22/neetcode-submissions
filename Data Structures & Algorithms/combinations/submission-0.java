class Solution {
    List<List<Integer>> combinations;

    public List<List<Integer>> combine(int n, int k) {
        combinations = new ArrayList<>();
        addNumbers(new ArrayList<>(), n, k, 1);

        return new ArrayList<>(combinations);
    }

    private void addNumbers(List<Integer> list, int n, int k, int i) {
        if (list.size() == k) combinations.add(new ArrayList<>(list));
        if (i > n || list.size() >= k) return;

        list.add(i);
        addNumbers(list, n, k, i + 1);

        list.remove(list.size() - 1);
        addNumbers(list, n, k, i + 1);
    }
}