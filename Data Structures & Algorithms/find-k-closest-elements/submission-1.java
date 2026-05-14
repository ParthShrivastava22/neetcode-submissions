class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = k;

        while(end < arr.length) {
            while(end < arr.length && arr[end] == arr[start]) {
                System.out.println(arr[start] + " " + arr[end]);
                end++;
            }

            if (end == arr.length) break;

            int a = arr[end], b = arr[start];

            if (Math.abs(a - x) < Math.abs(b - x)) {
                end++;
                start = end - k;
            } else break;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = start; i < start + k; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}