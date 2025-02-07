class Solution {
    public void BFS(int u, int[][] isConnected, boolean[] visited){
        visited[u] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i = 0; i< isConnected.length; i++){
                if(!visited[i] && isConnected[curr][i] == 1){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n+1];
        int count = 0;
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                count++;
                BFS(i,isConnected,visited);
            }
        }
        return count;
    }
}