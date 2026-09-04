class DSU
{
    int[] par;
    int n;
    DSU(int n)
    {
        this.n=n;
        par=new int[n];
        for(int i=0;i<n;i++)
            par[i]=i;
    }    
    public int find(int x)
    {
        if(par[x]==x) return x;
        return par[x]=find(par[x]);
    }
    public void union(int x,int y)
    {
        int parx=find(x),pary=find(y);
        if(parx!=pary)
            par[pary]=parx;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        DSU obj=new DSU(n);
        PriorityQueue<int[]> edges=new PriorityQueue<>((a,b)->a[2]-b[2]);
        Set<Integer> v=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int dist=Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);
                edges.add(new int[]{i,j,dist});
            }
        }
        int done=0,cost=0;
        while(!edges.isEmpty() && done<n-1)
        {
            int[] smallest=edges.poll();
            if(obj.find(smallest[0])==obj.find(smallest[1]))
                continue;
            obj.union(smallest[0],smallest[1]);
            cost+=smallest[2];
            done++;
        }
        return cost;
    }
}