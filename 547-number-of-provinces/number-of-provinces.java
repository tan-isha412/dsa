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
        return find(par[x]);
    }
    public void union(int x,int y)
    {
        int parx=find(x),pary=find(y);
        if(parx!=pary)
            par[pary]=parx;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DSU obj=new DSU(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j!=i && isConnected[i][j]==1)
                {
                    obj.union(i,j);
                }
            }
        }
        Set<Integer> v=new HashSet<>();
        for(int i=0;i<n;i++)
            v.add(obj.find(i));
        return v.size();
    }
}