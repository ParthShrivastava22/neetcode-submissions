class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        
       int[] tris = new int[n + 1];
       tris[1] = 1;
       tris[2] = 1;

       for (int i = 3; i <= n; i++) {
            tris[i] = tris[i - 2] + tris[i - 1] + tris[i - 3];
       }

       return tris[n];
    }
}