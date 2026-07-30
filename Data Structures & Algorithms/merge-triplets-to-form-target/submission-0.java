class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        boolean one = false, two = false, three = false;

        for (int[] triplet: triplets) {
            if (triplet[0] > target[0] || 
                triplet[1] > target[1] || triplet[2] > target[2]) continue;
            
            one = one || triplet[0] == target[0];
            two = two || triplet[1] == target[1];
            three = three || triplet[2] == target[2];
        }

        return one && two && three;
    }
}
