class Solution {
    public int evalRPN(String[] tokens) {
       int[] stack = new int[tokens.length];
       int head = -1;

       for (String token: tokens) {
        if (token.equals("+")) {
            int n1 = stack[head--];
            int n2 = stack[head];
            stack[head] = n1 + n2;
        }
        else if (token.equals("-")) {
                int n1 = stack[head--];
                int n2 = stack[head];

                stack[head] = n2 - n1;
            }
            else if (token.equals("*")) {
                int n1 = stack[head--];
                int n2 = stack[head];

                stack[head] = n2 * n1;
            }
            else if (token.equals("/")) {
                int n1 = stack[head--];
                int n2 = stack[head];

                stack[head] = n2 / n1;
            }
        else {
            stack[++head] = Integer.parseInt(token);
        }
       }

       return stack[head];
    }
}
