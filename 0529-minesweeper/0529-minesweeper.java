class Solution {
    int[][] dir={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    int n,m;
    public char[][] updateBoard(char[][] board, int[] click) {
        n=board.length;m=board[0].length;
        int r=click[0],c=click[1];
        if(board[r][c]=='M'){
            board[r][c]='X';
            return board;
        }
        dfs(board,r,c);
        return board;
    }
    public void dfs(char[][] board,int r,int c){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!='E') return ;
        int cnt=sol(board,r,c);
        if(cnt==0) board[r][c]='B';
        else board[r][c]=(char)(cnt+'0');
        if(cnt==0){
            for(int[] a:dir){
                dfs(board,r+a[0],c+a[1]);
            }
        }
    }
    public int sol(char[][] board,int r,int c){
        int cnt=0;
        for(int[] a:dir){
            int i=r+a[0],j=c+a[1];
            if(i>=0 && i<n && j>=0 && j<m && board[i][j]=='M'){
                cnt++;
            }
        }
        return cnt;
    }
}