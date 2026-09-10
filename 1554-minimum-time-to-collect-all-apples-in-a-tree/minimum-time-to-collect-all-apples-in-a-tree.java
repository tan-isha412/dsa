class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] e:edges)
        {
            int u=e[0],v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans=dfs(adj,-1,0,hasApple);
        return ans==-1?0:ans;
    }
    public int dfs(
    ArrayList<ArrayList<Integer>> adj,
    int parent,
    int node,
    List<Boolean> hasApple
) {
    int total = 0;
    boolean useful = hasApple.get(node);
    for (int child : adj.get(node)) {
        if (child == parent) {
            continue;
        }
        int childCost = dfs(adj, node, child, hasApple);
        if (childCost != -1) {
            useful = true;
            total += childCost + 2;
        }
    }
    return useful ? total : -1;
}
}