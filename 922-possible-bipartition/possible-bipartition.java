class DSU
{
    int[] par;
    int n;
    DSU(int n)
    {
        this.n=n;
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
        if(find(x)!=find(y))
            par[find(y)]=par[find(x)];
        return ;
    }
}
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] e:dislikes)
        {
            adj.get(e[0]-1).add(e[1]-1);
            adj.get(e[1]-1).add(e[0]-1);
        }
        DSU obj=new DSU(n);
        for(int i=0;i<n;i++)
        {
            for(int nei:adj.get(i))
            {
                if(obj.find(i)==obj.find(nei)) return false;
                obj.union(nei,adj.get(i).get(0));
            }
        }
        return true;    
    }
}