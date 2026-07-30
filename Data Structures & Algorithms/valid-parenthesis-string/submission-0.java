class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') open.push(i);
            else if (s.charAt(i) == '*') stars.push(i);
            else {
                if (!open.isEmpty()) open.pop();
                else if(!stars.isEmpty()) stars.pop();
                else return false;
            }
        }

        while(!open.isEmpty() && !stars.isEmpty()) {
            int op = open.pop(), star = stars.pop();

            if (star < op) return false;
        }

        return open.isEmpty();
    }
}
