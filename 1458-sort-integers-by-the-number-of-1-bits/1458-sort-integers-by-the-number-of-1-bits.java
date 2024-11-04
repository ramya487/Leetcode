class Solution {
    public static int noOfSetBit(int n){
         int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> {
            if (arr1[1] != arr2[1]) return Integer.compare(arr1[1], arr2[1]);
            return Integer.compare(arr1[0], arr2[0]);
        });
        
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int c = noOfSetBit(arr[i]);
            pq.add(new int[]{arr[i], c});
        }
        
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = pq.poll()[0];
        }
        
        return ret;
    }
}