class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < hand.length; i++) {
            treeMap.put(hand[i], treeMap.containsKey(hand[i]) ? treeMap.get(hand[i]) + 1
            : 1);
        }

        while(!treeMap.isEmpty()) {
            int currentGroup = groupSize - 1;
            int current = treeMap.firstKey();
            if (treeMap.get(current) == 1) treeMap.remove(current);
            else {
                treeMap.put(current, treeMap.get(current) - 1);
            }

            for (int i = 0; i < currentGroup; i++) {
                if (!treeMap.containsKey(current + 1)) return false;

                current++;
                if (treeMap.get(current) == 1) treeMap.remove(current);
                else {
                    treeMap.put(current, treeMap.get(current) - 1);
                }
            }
        }

        return true;
    }
}
