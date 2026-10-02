class Solution {
    int[] r={-1,1,0,0};
    int[] c={0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> q=new ArrayDeque<>();
        int m=grid.length,n=grid[0].length;
        int freshf=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    freshf++;
            }
        }
        if(freshf==0 || q.size()==m*n) return 0;
        if(q.isEmpty()) return -1;
        int minutes=1;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int j=0;j<s;j++)
            {
                int[] curr=q.poll();
                for(int i=0;i<4;i++)
                {
                    int newr=curr[0]+r[i],newc=curr[1]+c[i];
                    if(newr<0 || newc<0 || newr>=m || newc>=n || grid[newr][newc]!=1) continue;
                    grid[newr][newc]=2;
                    freshf--;
                    q.offer(new int[]{newr,newc});
                }
                if(freshf<=0)
                    return minutes;
            }
            minutes++;
        }
        return -1;
    }
}