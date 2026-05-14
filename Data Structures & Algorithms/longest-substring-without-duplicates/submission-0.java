class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int l = s.length();

        int start = 0;

        for (int end = 0; end < l; end++) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                maxLength = Math.max(maxLength, end - start + 1);
            }
            else {
                while(s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start++;
                }

                start++;
            }
        }

        return maxLength;
    }
}
