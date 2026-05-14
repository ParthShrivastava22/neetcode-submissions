class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, n = s.length(), j = n - 1;

        while(i < j) {
            while(i < n && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (j < 0 || i >= n) return true;

            char a = Character.toLowerCase(s.charAt(i));
            char b = Character.toLowerCase(s.charAt(j));
            if (a != b) return false;
            i++;
            j--;
        }

        return true;
    }
}
