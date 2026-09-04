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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emToID=new HashMap<>();
        Map<String,String> emToName=new HashMap<>();
        int id=0;
        for(List<String> acc:accounts)
        {
            String firstem=acc.get(0);
            for(int i=1;i<acc.size();i++)
            {
                if(!emToName.containsKey(acc.get(i)))
                {
                emToID.put(acc.get(i),id++);
                emToName.put(acc.get(i),firstem);
                }
            }
        }
        DSU obj=new DSU(id);
        for(List<String> acc:accounts)
        {
            for(int i=2;i<acc.size();i++)
            {
                obj.union(emToID.get(acc.get(1)),emToID.get(acc.get(i)));
            }
        }
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String email : emToID.keySet()) {
            int root = obj.find(emToID.get(email));
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        // Step 4: Sort emails and format the final output list
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> component : groups.values()) {
            Collections.sort(component);
            List<String> account = new ArrayList<>();
            account.add(emToName.get(component.get(0))); // Add the account name first
            account.addAll(component);                     // Add sorted emails
            mergedAccounts.add(account);
        }

        return mergedAccounts;
    }
}