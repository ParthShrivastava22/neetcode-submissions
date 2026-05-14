class Solution {
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];

        int start = 0, maxCount = 0;

        for (int end = 0; end < s.length(); end++) {
            int charIndex = s.charAt(end) - 'A';
            chars[charIndex]++;
            maxCount = Math.max(maxCount, chars[charIndex]);

            if (end - start + 1 - maxCount > k) {
                chars[s.charAt(start) - 'A']--;
                start++;
            }
        }

        return s.length() - start;
    }
}
