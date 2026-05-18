class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateSequence(list, new ArrayList<>(), n, 0, 0);

        return list;
    }

    private void generateSequence(List<String> list, List<Character> current, int n, 
                    int open, int close) {
        if (current.size() == n * 2) {
            if (open == close) addToList(list, current);
            return;
        }

        if (close < open) {
            close++;
            current.add(')');
            generateSequence(list, current, n, open, close);
            current.remove(current.size() - 1);
            close--;
        }

        if (open < n) {
            open++;
            current.add('(');
            generateSequence(list, current, n, open, close);
            current.remove(current.size() - 1);
            open--;
        }
    }

    private void addToList(List<String> list, List<Character> current) {
        StringBuilder builder = new StringBuilder();
        for (char c: current) {
            builder.append(c);
        }

        list.add(builder.toString());
    }
}
