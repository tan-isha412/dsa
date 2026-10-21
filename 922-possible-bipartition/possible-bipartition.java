class DSU
{
    int[] p;
    DSU(int n)
    {
        this.p=new int[n];
        for(int i=0;i<n;i++)
            this.p[i]=i;
    }
    public int find(int x)
    {
        if(p[x]==x) return x;
        return p[x]=find(p[x]);
    }
    public void union(int x,int y)
    {
        int px=find(x),py=find(y);
        if(px!=py)
            p[py]=px;
    }
}
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        DSU obj=new DSU(n+1);
        ArrayList<ArrayList<Integer>> dl=new ArrayList<>();
        for(int i=0;i<=n;i++) dl.add(new ArrayList<>());
        for(int[] d:dislikes)
        {
            dl.get(d[0]).add(d[1]);
            dl.get(d[1]).add(d[0]);
        }
        for(int i=1;i<=n;i++)
        {
            for(int e:dl.get(i))
            {
                if(obj.find(e)==obj.find(i)) return false;
                obj.union(dl.get(i).get(0),e);
            }
        }
        
        return true;
    }
}