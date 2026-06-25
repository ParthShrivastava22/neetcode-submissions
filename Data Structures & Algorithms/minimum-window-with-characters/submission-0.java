class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[58];
        for (char c: t.toCharArray()) {
            freq[c - 'A']++;
        }

        String current = "";
        int i = 0, j = 0, minLength = s.length();
        freq[s.charAt(0) - 'A']--;

        while(j < s.length()) {
            if(hasPositive(freq)) {
                j++;
                if (j == s.length()) break;
                freq[s.charAt(j) - 'A']--;
            } else {
                if (j - i + 1 <= minLength) {
                    current = s.substring(i, j + 1);
                    minLength = j - i + 1;
                } 
                freq[s.charAt(i) - 'A']++;
                i++;
            }
        }

        return current;
    }

    private boolean hasPositive(int[] arr) {
        for (int num : arr) {
            if (num > 0) {
                return true;
            }
        }
        return false;
    }
}
