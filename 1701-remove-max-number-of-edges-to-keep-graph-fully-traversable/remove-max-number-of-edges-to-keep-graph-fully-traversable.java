class DSU
{
    int[] par;
    int comp;
    int n;
    DSU(int n)
    {
        this.n=n;
        this.par=new int[n];
        this.comp=n;
        for(int i=0;i<n;i++)
            this.par[i]=i;
    }
    public int find(int x)
    {
        if(this.par[x]==x)
            return x;
        return this.par[x]=find(par[x]);
    }
    public boolean union(int x,int y)
    {
        if(find(x)!=find(y))
        {
            this.par[find(x)]=this.par[find(y)];
            this.comp--;
            return true;
        }
        return false;
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU a=new DSU(n);
        DSU b=new DSU(n);
        int edgesused=0;
        for(int[] e:edges)
        {
            if(e[0]==3)
            {
                boolean ua=a.union(e[1]-1,e[2]-1);
                boolean ub=b.union(e[1]-1,e[2]-1);
                if(ua || ub)
                    edgesused++;
            }
        }
        for(int[] e:edges)
        {
            if(e[0]==1)
            {
                boolean ua=a.union(e[1]-1,e[2]-1);
                if(ua) edgesused++;
            }
            else if(e[0]==2)
            {
                boolean ub=b.union(e[1]-1,e[2]-1);
                if(ub) edgesused++;
            }
        }
        if(a.comp==1 && b.comp==1)
        {
            return edges.length-edgesused;
        }
        return -1;
    }
}