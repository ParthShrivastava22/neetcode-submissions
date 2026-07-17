class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (target < matrix[mid][0]) right = mid - 1;
            else left = mid + 1;
        }

        int row = right;
        if (row == -1) return false;

        int l = 0, r = matrix[0].length - 1;

        while(l <= r) {
            int m = (r - l) / 2 + l;

            if (target == matrix[row][m]) return true;
            else if (target > matrix[row][m]) l = m + 1;
            else r = m - 1;
        }

        return false;
    }
}
