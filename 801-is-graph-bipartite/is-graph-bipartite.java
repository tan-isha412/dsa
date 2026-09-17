class DSU
{
    int n;
    int[] par;
    DSU(int n)
    {
        this.n=n;
        this.par=new int[n];
        for(int i=0;i<n;i++)
            this.par[i]=i;
    }
    public void union(int x,int y)
    {
        int px=find(x);
        int py=find(y);
        if(px!=py)
            this.par[py]=par[px];
        return ;
    }
    public int find(int x)
    {
        if(this.par[x]==x) return x;
        return par[x]=find(par[x]);
    }
}
   
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        DSU obj=new DSU(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                if(obj.find(i)==obj.find(graph[i][j])) return false;
                obj.union(graph[i][0],graph[i][j]);
            }
        }
        
        return true;
    }
}