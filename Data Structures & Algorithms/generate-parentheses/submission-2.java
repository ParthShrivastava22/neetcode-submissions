class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateSequence(list, new char[n * 2], n, 0, 0, 0);

        return list;
    }

    private void generateSequence(List<String> list, char[] current, int n, int pos, 
                    int open, int close) {
        if (pos == current.length) {
            list.add(new String(current));
            return;
        }

        if (close < open) {
            current[pos] = ')';
            generateSequence(list, current, n, pos + 1, open, close + 1);
        }

        if (open < n) {
            current[pos] = '(';
            generateSequence(list, current, n, pos + 1, open + 1, close);
        }
    }
}
