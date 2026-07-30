class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        int l = s.length();

        for (int i = 0; i < l; i++) {
            map[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = map[s.charAt(0) - 'a'];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            end = Math.max(end, map[s.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }

        return list;
    }
}
