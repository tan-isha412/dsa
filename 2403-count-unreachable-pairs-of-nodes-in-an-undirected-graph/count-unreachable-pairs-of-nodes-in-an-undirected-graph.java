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
    public int find(int x)
    {
        if(this.par[x]==x)
            return x;
        return par[x]=find(par[x]);
    }
    public void union(int x,int y)
    {
        int px=find(x),py=find(y);
        if(px!=py)
            par[px]=find(py);
    }
}
class Solution {
    public long countPairs(int n, int[][] edges) {
        DSU obj=new DSU(n);
        for(int[] e:edges)
            obj.union(e[0],e[1]);
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            int par=obj.find(i);
            arr[par]++;
        }
        long sum=0,nodesProcessed=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)
            {
                sum+=arr[i]*nodesProcessed;
                nodesProcessed+=arr[i];
            }
        }
        return sum;
    }
}