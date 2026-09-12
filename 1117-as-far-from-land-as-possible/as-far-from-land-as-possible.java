class Solution {
    int[] r={-1,1,0,0};
    int[] c={0,0,-1,1};
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    q.offer(new int[]{i,j});
            }
        }
        if(q.isEmpty() || q.size()==n*n) return -1;
        int level=-1;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int j=0;j<s;j++)
            {
                int[] curr=q.poll();
                for(int i=0;i<4;i++)
                {
                    int newr=curr[0]+r[i],newc=curr[1]+c[i];
                    if(newr<0 || newc<0 || newr>=n || newc>=n || grid[newr][newc]==1) continue;
                    grid[newr][newc]=1;
                    q.offer(new int[]{newr,newc});
                }
            }
            level++;
        }
        return level;
    }
}