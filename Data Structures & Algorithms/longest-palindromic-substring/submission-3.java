class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];

        int[] largest = new int[2];

        for (int i = 0; i < n; i++) {
            memo[i][i] = 1;
            largest[0] = i;
            largest[1] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (i == 1) {
                    memo[j][j + i] = (s.charAt(j) == s.charAt(j + i)) ? 1 : -1;
                } else {
                    memo[j][j + i] = (s.charAt(j) == s.charAt(j + i)
                            && memo[j + 1][j + i - 1] == 1) ? 1 : -1;
                }

                if (memo[j][j + i] == 1) {
                    largest[0] = j;
                    largest[1] = j + i;
                }
            }
        }

        return s.substring(largest[0], largest[1] + 1);
    }
}
