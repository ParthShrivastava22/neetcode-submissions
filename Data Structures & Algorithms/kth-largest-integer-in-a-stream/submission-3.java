class KthLargest {
    ArrayList<Integer> array;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        array = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            array.add(nums[i]);
        }

        array.sort(Collections.reverseOrder());
    }
    
    public int add(int val) {
        array.add(val);
        array.sort(Collections.reverseOrder());
        return array.get(k - 1);
    }
}
