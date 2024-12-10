class Solution {
    class SegmentTree {
        private int N;
        private int[] node;
        SegmentTree(int n) {
            // N = Round up n to the next highest power of 2 (i.e. N = 1 for n = 1; N = 2 for n = 2; N = 4 for n = 3, 4; N = 8 for n = 5, 6, 7, 8; and so on)
			N = 1;
            while(N < n) {
                N <<= 1;
            }
            node = new int[(N << 1) - 1];  // total no of nodes in the tree: 2*N-1
            for(int i = 0; i < n; i++) {  // leaf nodes: initialize each with 1 available spot
                node[N - 1 + i] = 1;
            }
            for(int i = N - 2; i >= 0; i--) {  // internal nodes: calculate available spots as sum of available spots in child nodes
                node[i] = node[(i<<1) + 1] + node[(i<<1) + 2];  // left child: 2*i+1, right child: 2*i+2
            }
        }
        public int insert(int k) { // return the index of k'th 1 and make it 0
            int i = 0; // root node
            while(i < N - 1) {  // internal nodes
                node[i]--;  // decrement available spots by 1 as we go down towards leaf node
                int left = (i<<1) + 1;
                if(node[left] > k) {  // decide whether to go to left child or to right child based on available spots in them
                    i = left;
                } else {
                    i = left + 1;  // left + 1 means right
                    k -= node[left];  // if going to right child, reduce k by the no of available spots in left child
                }
            }
            node[i]--;  // this is the target leaf node: make 1 to 0
            return i - N + 1;  // convert to the index that caller expects; leaf nodes begin at N-1
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);  // compare (h, k) by h; in case of ties, compare k in reverse order
        int n = people.length;
        SegmentTree st = new SegmentTree(n);
        int[][] res = new int[n][];
        for(int[] p: people) {
            res[st.insert(p[1])] = p;  // place p at the index of the k'th available spot returned by segment tree
        }
        return res;
    }
}