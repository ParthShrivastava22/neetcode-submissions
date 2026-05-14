class Solution {
    public String decodeString(String s) {
        int length = s.length();
        StringBuilder[] stack = new StringBuilder[length];
        int head = -1;
        int[] numStack = new int[length];
        int numHead = -1;

        int k = 0;
        StringBuilder string = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            }
            else if (c == '[') {
                numStack[++numHead] = k;
                k = 0;

                stack[++head] = string;
                string = new StringBuilder();
            }
            else if (c == ']') {
                StringBuilder previous = stack[head--];
                int m = numStack[numHead--];

                for (int i = 0; i < m; i++) {
                    previous.append(string);
                }
                string = previous;
            }
            else {
                string.append(c);
            }
        }

        return string.toString();
    }
}