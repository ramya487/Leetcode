// bfs
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for (int i = 0; i<prerequisites.length; i++){
            int[] arry = prerequisites[i];
            adj.get(arry[1]).add(arry[0]); // adj list construction
            indeg[arry[0]]++; // indeg calc
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<n; i++){
            if (indeg[i] == 0) q.offer(i);
        }

        int[] topo = new int[n];
        int c = 0;
        while (!q.isEmpty()){
            int frnt = q.poll();
            topo[c++] = frnt;
            for (int it: adj.get(frnt)){
                indeg[it]--;
                if (indeg[it] == 0){
                    q.offer(it);
                }
            }
        }
        if (c == n) return topo;
        int[] arr = {};
        return arr;
    }
}