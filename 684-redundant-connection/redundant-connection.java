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
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU obj=new DSU(n);
        for(int[] e:edges)
        {
            if(obj.find(e[0]-1)==obj.find(e[1]-1))
                return e;
            obj.union(e[0]-1,e[1]-1);
        }
        return new int[]{-1,-1};
    }
}