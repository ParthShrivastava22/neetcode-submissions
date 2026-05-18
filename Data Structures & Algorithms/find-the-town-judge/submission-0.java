class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] trusts = new boolean[n];
        int[] trustCount = new int[n];

        for (int[] person: trust) {
            trusts[person[0] - 1] = true;
            trustCount[person[1] - 1] += 1;
        }

        List<Integer> suspectList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!trusts[i] && trustCount[i] == n - 1) suspectList.add(i);
        }

        return suspectList.size() == 1 ? suspectList.get(0) + 1 : -1;
    }
}