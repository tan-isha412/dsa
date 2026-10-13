class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> currPath=new ArrayList<>();
        currPath.add(0);
        List<List<Integer>> ans=new ArrayList<>();
        addPath(0,graph,currPath,ans);
        return ans;
    }
    public void addPath(int curr,int[][] graph,List<Integer> currPath,List<List<Integer>> ans)
    {
        if(curr==graph.length-1)
        {
            ans.add(new ArrayList<>(currPath));
            return;
        }
        for(int nei:graph[curr])
        {
            if(currPath.contains(nei)) continue;
            currPath.add(nei);
            addPath(nei,graph,currPath,ans);
            currPath.remove(currPath.size()-1);
        }
    }
}