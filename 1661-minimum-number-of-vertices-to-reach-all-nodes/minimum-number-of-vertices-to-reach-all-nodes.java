class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indeg=new int[n];
        for(List<Integer> e:edges)
            indeg[e.get(1)]++;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(indeg[i]==0)
                ans.add(i);
        }
        return ans;
    }
}