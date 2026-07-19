class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length, n = nums2.length;
        int leftMax = (m + n + 1) / 2;

        int left = 0, right = m;
        while (left <= right) {
            int i = (right - left) / 2 + left;
            int j = leftMax - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int Bleft = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                double median;
                if ((m + n) % 2 == 0) {
                    median = (Math.max(Aleft, Bleft) + Math.min(Aright,Bright)) / 2.0;
                }
                else median = Math.max(Aleft, Bleft);

                return median;
            } else if (Bleft > Aright) left = i + 1;
            else right = i - 1;
        }

        return 0.0;
    }
}
