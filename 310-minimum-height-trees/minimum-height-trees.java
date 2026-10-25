class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Collections.singletonList(0);
        List<Integer> ans=new ArrayList<>();
        int[] indegree=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] e:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }
        ArrayDeque<Integer> pq=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==1)
                pq.offer(i);
        }
        int rem=n;
        while(rem>2)
        {
            int s=pq.size();
            rem-=s;
            for(int i=0;i<s;i++)
            {
                int curr=pq.poll();
                for (int nei : adj.get(curr)) {
                indegree[nei]--;
                if(indegree[nei]==1)
                    pq.offer(nei);
                }
            }
        }
        return new ArrayList<>(pq);
    }
}