class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int k = s1.length(), l = s2.length();
        int[] map = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < k; i++) {
            map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < k; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(map, window)) return true;

        for (int i = k; i < l; i++) {
            window[s2.charAt(i - k) - 'a']--;
            window[s2.charAt(i) - 'a']++;

            if (Arrays.equals(window, map)) return true;
        }

        return false;
    }
}
