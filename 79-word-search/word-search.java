class Solution {
    int[] r={-1,1,0,0};
    int[] c={0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(bfs(i,j,board,word,0)) return true;
                }
            }
        }
        return false;
    }
    public boolean bfs(int i,int j,char[][] board,String word,int idx)
    {
        if(idx==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(idx)) return false;
        char ch=board[i][j];
        board[i][j]='.';
        for(int k=0;k<4;k++)
        {
            int newi=i+r[k],newj=j+c[k];
            if(bfs(newi,newj,board,word,idx+1)) return true;
        }
        board[i][j]=ch;
        return false;
    }
}