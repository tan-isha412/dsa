class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        for(int[] e:edges)
        {
            int u=e[0],v=e[1],d=e[2];
            dist[u][v]=d;
            dist[v][u]=d;
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i!=k && j!=k && (dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE))
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int minm=n;
        int v=0;
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            for(int j=0;j<n;j++)
            {
                if(j!=i && dist[i][j]<=distanceThreshold)
                    cnt++;
            }
            if(cnt<=minm)
            {
                minm=cnt;
                v=i;
            }
        }
        return v;
    }
}