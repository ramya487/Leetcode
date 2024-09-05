// T- O(nlogk)
// S- O(k)
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] ret = new int[n];

        // priority queue with reverse ordering
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i<n; i++){
            int d = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            if (i+1<k) {
                ret[i] = -1;
                pq.offer(d);
            }
            else{
                if (pq.size() == k){
                    pq.offer(d);
                    pq.poll();
                    ret[i] = pq.peek();
                }else{
                    pq.offer(d);
                    if (i+1 == k){
                        ret[i] = pq.peek();
                    }
                }
            }
        }
        return ret;
    }
}