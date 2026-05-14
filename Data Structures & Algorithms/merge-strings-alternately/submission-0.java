class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder word3 = new StringBuilder();
        int i = 0, j = 0;
        int l1 = word1.length(), l2 = word2.length();

        while(i < l1 && j < l2) {
            word3.append(word1.charAt(i++));
            word3.append(word2.charAt(j++));
        }
        while(i < l1) {
            word3.append(word1.charAt(i++));
        }
        while(j < l2) {
            word3.append(word2.charAt(j++));
        }

        return word3.toString();
    }
}