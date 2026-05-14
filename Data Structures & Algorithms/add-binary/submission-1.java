class Solution {
    public String addBinary(String a, String b) {
        StringBuilder c = new StringBuilder();
        int l1 = a.length() - 1, l2 = b.length() - 1;

        int carry = 0;
        while(l1 >= 0 || l2 >= 0) {
            int i = l1 >= 0 ? a.charAt(l1) - '0' : 0;
            int j = l2 >= 0 ? b.charAt(l2) - '0' : 0;

            c.append((i ^ j) ^ carry);
            carry = (i & j) | (i & carry) | (j & carry);
            l1--;
            l2--;
        }

        if (carry == 1) c.append(1);

        return c.reverse().toString();
    }
}