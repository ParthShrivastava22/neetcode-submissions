class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int l = s.length();
        
        // Optimization: Use 1 array instead of 2
        int[] count = new int[26];
        
        for (int i = 0; i < l; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < l; i++) {
            if (count[t.charAt(i) - 'a']-- == 0) return false;
        }
        
        return true;
    }
}