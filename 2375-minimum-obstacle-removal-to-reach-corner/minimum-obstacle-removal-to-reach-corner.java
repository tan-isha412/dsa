class Solution {
    int[] row={-1,1,0,0};
    int[] col={0,0,-1,1};
    public int minimumObstacles(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[0][0]=0;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int[] curr=q.poll();
                int r=curr[0],c=curr[1],minm=curr[2];
                if(minm>dist[r][c]) continue;
                for(int j=0;j<4;j++)
                {
                    int newr=r+row[j],newc=c+col[j];
                    if(newr<0 || newr>=m || newc<0 || newc>=n) continue;
                    int co=grid[newr][newc];
                    if(minm+co<dist[newr][newc])
                    {
                        dist[newr][newc]=minm+co;
                        if(co==0)
                            q.addFirst(new int[]{newr,newc,minm});
                        else
                            q.addLast(new int[]{newr,newc,minm+co});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}