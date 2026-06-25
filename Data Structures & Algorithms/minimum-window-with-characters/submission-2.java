class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[58];
        for (char c: t.toCharArray()) {
            freq[c - 'A']++;
        }
        int missing = t.length();

        int bestStart = 0, bestLength = 0;
        int i = 0, j = 0, minLength = s.length();

        if (freq[s.charAt(0) - 'A'] > 0) missing--;
        freq[s.charAt(0) - 'A']--;

        while(j < s.length()) {
            if (missing != 0) {
                j++;
                if (j == s.length()) break;

                if (freq[s.charAt(j) - 'A'] > 0) missing--;
                freq[s.charAt(j) - 'A']--;
            } else {
                if (j - i + 1 <= minLength) {
                    minLength = j - i + 1;
                    bestStart = i;
                    bestLength = minLength;
                } 
                freq[s.charAt(i) - 'A']++;
                if (freq[s.charAt(i) - 'A'] > 0) missing++;
                i++;
            }
        }

        return s.substring(bestStart, bestStart + bestLength);
    }
}
