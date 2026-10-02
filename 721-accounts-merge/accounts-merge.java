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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int id=0;
        Map<String,String> emToName=new HashMap<>();
        Map<String,Integer> emToID=new HashMap<>();
        for(List<String> acc:accounts)
        {
            String name=acc.get(0);
            for(int i=1;i<acc.size();i++)
            {
                if(!emToID.containsKey(acc.get(i)))
                {
                    emToID.put(acc.get(i),id++);
                    emToName.put(acc.get(i),name);
                }
            }
        }
        DSU obj=new DSU(id);
        for(List<String> acc:accounts)
        {
            String parem=acc.get(1);
            for(int i=2;i<acc.size();i++)
                obj.union(emToID.get(parem),emToID.get(acc.get(i)));
        }
        Map<Integer,List<String>> paridToEm=new HashMap<>();
        for(String em:emToName.keySet())
        {
            int parID=obj.find(emToID.get(em));
            if (!paridToEm.containsKey(parID)) 
                paridToEm.put(parID, new ArrayList<>());
            paridToEm.get(parID).add(em);
        }
        List<List<String>> ans=new ArrayList<>();
        for(List<String> grp:paridToEm.values())
        {
            List<String> one=new ArrayList<>();
            String name=emToName.get(grp.get(0));
            Collections.sort(grp);
            one.add(name);
            one.addAll(grp);
            ans.add(new ArrayList<>(one));
        }
        return ans;
    }
}