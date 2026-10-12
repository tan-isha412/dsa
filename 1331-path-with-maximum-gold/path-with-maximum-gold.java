class Solution {
    int[] row={1,0,0,-1};
    int[] col={0,1,-1,0};
    public int getMaximumGold(int[][] grid) {
        int maxm=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]>0)
                    maxm=Math.max(maxm,dfs(i,j,grid,0));
            }
        }
        return maxm;
    }
    public int dfs(int r,int c,int[][] grid,int val)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0)
            return val;
        int curr=grid[r][c];
        grid[r][c]=0;
        int maxm=val+curr;
        for(int i=0;i<4;i++)
        {
            int newr=r+row[i],newc=c+col[i];
            int bb=dfs(newr,newc,grid,val+curr);
            maxm=Math.max(maxm,bb);
        }
        grid[r][c]=curr;
        return maxm;
    }
}