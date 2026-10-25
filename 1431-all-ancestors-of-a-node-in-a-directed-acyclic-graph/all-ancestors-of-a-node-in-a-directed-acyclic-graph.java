class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] e:edges)
            adj.get(e[1]).add(e[0]);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(adj.get(i)!=null)
            {
                List<Integer> a=bfs(i,adj,new ArrayList<>());
                a.remove(0);
                Collections.sort(a);
                ans.add(new ArrayList<>(a));
            }
            else
                ans.add(new ArrayList<>());
        }
        return ans;
    }
    public List<Integer> bfs(int curr,List<List<Integer>> adj,List<Integer> a)
    {
        a.add(curr);
        for(int nei:adj.get(curr))
        {
            if(!a.contains(nei))
                bfs(nei,adj,a);
        }
        return a;
    }
}