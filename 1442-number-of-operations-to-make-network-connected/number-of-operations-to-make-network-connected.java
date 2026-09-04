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
    public int makeConnected(int n, int[][] connections) {
        DSU obj=new DSU(n);
        int cnt=0;
        for(int[] c:connections)
        {
            if(obj.find(c[0])==obj.find(c[1]))
                cnt++;
            else
                obj.union(c[0],c[1]);
        }
        int unique=0;
        for(int i=0;i<n;i++)
        {
            if(obj.find(i)==i)
            unique++;
        }
        if(unique>cnt+1) return -1;
        return unique-1;
    }
}