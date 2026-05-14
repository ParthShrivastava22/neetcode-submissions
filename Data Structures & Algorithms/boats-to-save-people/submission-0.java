class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0, i = 0, j = people.length - 1;

        while(i <= j) {
            if (i == j) {
                count++;
                break;
            }

            int netWeight = people[i] + people[j];

            if (netWeight > limit) {
                count++;
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }

        return count;
    }
}