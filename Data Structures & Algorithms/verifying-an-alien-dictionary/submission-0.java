class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alpha = new int[26];
        int pos = 0;

        for (char c: order.toCharArray()) {
            alpha[c - 'a'] = pos++;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int l1 = w1.length(), l2 = w2.length();
            boolean confirm = false;
            int l = Math.min(l1, l2);

            for (int j = 0; j < l; j++) {
                if (alpha[w1.charAt(j) - 'a'] > alpha[w2.charAt(j) - 'a']) return false;
                else if (alpha[w1.charAt(j) - 'a'] < alpha[w2.charAt(j) - 'a']) {
                    confirm = true;
                    break;
                }
            }

            if (!confirm && l1 > l2) return false;
        }

        return true;
    }
}