class Solution {
    int[] row={1,-1,0,0};
    int[] col={0,0,1,-1};
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][0]==1)
                dfs(i,0,grid);
            if(grid[i][grid[0].length-1]==1)
                dfs(i,grid[0].length-1,grid);
        }
        for(int i=0;i<grid[0].length;i++)
        {
            if(grid[0][i]==1)
                dfs(0,i,grid);
            if(grid[grid.length-1][i]==1)
                dfs(grid.length-1,i,grid);
        }
        int cnt=0;
        for(int i=1;i<grid.length-1;i++)
        {
            for(int j=1;j<grid[0].length;j++)
            {
                if(grid[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int r,int c,int[][] grid)
    {
        grid[r][c]=-1;
        for(int i=0;i<4;i++)
        {
            int newr=r+row[i],newc=c+col[i];
            if(newr<0 || newc<0 || newr>=grid.length || newc>=grid[0].length || grid[newr][newc]!=1) continue;
            dfs(newr,newc,grid);
        }
    }
}