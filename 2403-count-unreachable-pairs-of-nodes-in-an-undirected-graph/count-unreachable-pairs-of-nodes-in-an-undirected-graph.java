class DSU
{
    int[] par;
    DSU(int n)
    {
        this.par=new int[n];
        for(int i=0;i<n;i++)
            this.par[i]=i;
    }
    public int find(int x)
    {
        if(par[x]==x) return x;
        return par[x]=find(par[x]);
    }
    public void union(int x,int y)
    {
        int px=find(x),py=find(y);
        if(px!=py)
            par[py]=px;
    }
}
class Solution {
    public long countPairs(int n, int[][] edges) {
        DSU obj=new DSU(n);
        for(int[] e:edges)
            obj.union(e[0],e[1]);
        int[] kids=new int[n];
        for(int i=0;i<n;i++)
        {
            int p=obj.find(i);
            kids[p]++;
        }
        long sum = 0;
        long remainingNodes = n;
        for (int i = 0; i < n; i++) 
        {
            if (kids[i] > 0) {
                remainingNodes -= kids[i];
                sum += (long) kids[i] * remainingNodes;
            }
        }
        return sum;
    }
}