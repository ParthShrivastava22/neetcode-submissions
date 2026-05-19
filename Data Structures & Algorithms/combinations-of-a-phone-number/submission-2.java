class Solution {
    public List<String> letterCombinations(String digits) {
        String[] numbers = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combos = new ArrayList<>();

        if (digits.equals("")) return combos;
        addCombination(digits, combos, new StringBuilder(), numbers, 0);
        return combos;
    }

    private void addCombination(String digits, List<String> combos, StringBuilder 
                current, String[] numbers, int i) {
        if (current.length() == digits.length()) {
            combos.add(current.toString());
            return;
        }

        String number = numbers[digits.charAt(i) - '2'];

        for (char c: number.toCharArray()) {
            current.append(c);
            addCombination(digits, combos, current, numbers, i + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
