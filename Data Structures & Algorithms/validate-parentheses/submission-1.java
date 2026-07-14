class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('{', '}');
        brackets.put('[', ']');
        brackets.put('(', ')');

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;

                char closing = brackets.get(stack.peek());
                if (closing != c) return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
