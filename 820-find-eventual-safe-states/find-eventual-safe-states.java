class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> ans=new ArrayList<>();
        int[] state=new int[n];
        for(int i=0;i<n;i++)
        {
            if(dfs(i,graph,state))
                ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int start,int[][] graph,int[] state)
    {
        if(state[start]==2) return true;
        if(state[start]==1) return false;
        state[start]=1;
        for(int nei:graph[start])
        {
            if(!dfs(nei,graph,state))
                return false;
        }
        state[start]=2;
        return true;
    }
}