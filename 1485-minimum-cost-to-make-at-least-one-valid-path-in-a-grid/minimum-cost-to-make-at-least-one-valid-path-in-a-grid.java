class Solution {
    int[] r = {0, 0, 1, -1};
    int[] c = {1, -1, 0, 0};
    public int minCost(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[0][0]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            int row=curr[0],col=curr[1];
            if(curr[2]>dist[row][col]) continue;
            if(row==grid.length-1 && col==grid[0].length-1) return curr[2];
            int idx=grid[row][col]-1;
            for(int i=0;i<4;i++)
            {
                int newr=row+r[i],newc=col+c[i];
                if(newr<0 || newc<0 || newr>=grid.length || newc>=grid[0].length) continue;
                int cost=(i==idx)?0:1;
                if(dist[newr][newc]>dist[row][col]+cost)
                {
                    dist[newr][newc]=dist[row][col]+cost;
                    q.offer(new int[]{newr,newc,dist[newr][newc]});
                }
            }
        }
        return -1;
    }
}