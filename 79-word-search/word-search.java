class Solution {
    int[] row={-1,1,0,0};
    int[] col={0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        char start=word.charAt(0);
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==start)
                {
                    if(dfs(0,i,j,board,word)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int idx,int r,int c,char[][] board,String word)
    {
        if(idx==word.length()) return true;
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]=='.' || board[r][c]!=word.charAt(idx)) return false;
        char ch=board[r][c];
        board[r][c]='.';
        for(int i=0;i<4;i++)
        {
            int newr=r+row[i],newc=c+col[i];
            if(dfs(idx+1,newr,newc,board,word))
                return true;
        }
        board[r][c]=ch;
        return false;
    }
}