class Solution {
    public List<String> letterCombinations(String digits) {
        String[] numbers = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combos = new ArrayList<>();

        if (digits.equals("")) return combos;
        addCombination(digits, combos, new ArrayList<>(), numbers, 0);
        return combos;
    }

    private void addCombination(String digits, List<String> combos, List<Character> 
                current, String[] numbers, int i) {
        if (current.size() == digits.length()) {
            addToList(combos, current);
            return;
        }

        String number = numbers[digits.charAt(i) - '2'];

        for (char c: number.toCharArray()) {
            current.add(c);
            addCombination(digits, combos, current, numbers, i + 1);
            current.remove(current.size() - 1);
        }
    }

    private void addToList(List<String> combos, List<Character> current) {
        StringBuilder sb = new StringBuilder();

        for (char c: current) {
            sb.append(c);
        }

        combos.add(sb.toString());
    }
}
