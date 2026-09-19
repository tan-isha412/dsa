class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(board,i,j,0,"",word)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int r,int c,int idx,String str,String word)
    {
        if(idx==word.length())
            return true;
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]=='.' || board[r][c]!=word.charAt(idx)) return false;
        str+=board[r][c];
        char ch=board[r][c];
        board[r][c]='.';
        boolean ans=dfs(board,r-1,c,idx+1,str,word)||dfs(board,r+1,c,idx+1,str,word)||dfs(board,r,c-1,idx+1,str,word)||dfs(board,r,c+1,idx+1,str,word);
        board[r][c]=ch;
        return ans;

    }
}