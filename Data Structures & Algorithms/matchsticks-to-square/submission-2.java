class Solution {
    public boolean makesquare(int[] matchsticks) {
        int perimeter = 0, max = 0, l = matchsticks.length;

        for (int i = 0; i < l; i++) {
            perimeter += matchsticks[i];
            max = Math.max(matchsticks[i], max);
        }

        int side = perimeter / 4;

        if (perimeter % 4 != 0 || max > side) return false;
        boolean[] chosen = new boolean[l];
        sortDescending(matchsticks);

        return dfs(matchsticks, side, chosen, 0, l, 0);
    }

    private boolean dfs(int[] matchsticks, int side, boolean[] chosen, int current,
                        int remaining, int startIndex) {
        if (remaining == 0) {
            if (current == 0) return true;
            return false;
        }

        int l = matchsticks.length;

        for (int i = startIndex; i < l; i++) {
            if (chosen[i]) continue;

            if (current + matchsticks[i] < side) {
                chosen[i] = true;
                if (dfs(matchsticks, side, chosen, current + matchsticks[i], remaining - 1, i + 1)) {
                    return true;
                }
                chosen[i] = false;
            }

            if (current + matchsticks[i] == side) {
                chosen[i] = true;
                if (dfs(matchsticks, side, chosen, 0, remaining - 1, 0)) {
                    return true;
                }
                chosen[i] = false;
            }
        }

        return false;
    }

    private void sortDescending(int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers toward the center
            left++;
            right--;
        }
    }
}