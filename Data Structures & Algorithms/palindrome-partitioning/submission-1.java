class Solution {
    public List<List<String>> partition(String s) {
        int[][] palindrome = new int[s.length()][s.length()];
        List<List<String>> finalList = new ArrayList<>();
        addIfPalindrome(finalList, new ArrayList<>(), s, 0, palindrome);
        return finalList;
    }

    private void addIfPalindrome(List<List<String>> finalList, List<String> list, 
            String s, int i, int[][] palindrome) {
        if (i >= s.length()) {
            finalList.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, palindrome, i, j)) {
                list.add(s.substring(i, j + 1));
                addIfPalindrome(finalList, list, s, j + 1, palindrome);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int[][] palindrome, int i, int j) {
        if (palindrome[i][j] == 1) return true;
        else if (palindrome[i][j] == -1) return false;

        if (i >= j) {
            palindrome[i][j] = 1;
            return true;
        }

        boolean yes = s.charAt(i) == s.charAt(j) &&
                        isPalindrome(s, palindrome, i + 1, j - 1);
        palindrome[i][j] = yes ? 1 : -1;
        return yes;
    }
}
