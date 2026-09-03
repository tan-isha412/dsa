class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        int[] indegree=new int[n+1];
        int[] maxT=new int[n+1];
        for(int[] r:relations)
        {
            adj.get(r[0]).add(r[1]);
            indegree[r[1]]++;
        }
        ArrayDeque<Integer> pq=new ArrayDeque<>();
        for(int i=1;i<=n;i++)
        {
            if(indegree[i]==0) {
                pq.offer(i);
                maxT[i]=time[i-1];
            }
        }
        while(!pq.isEmpty())
        {
            int s=pq.size();
            for(int i=0;i<s;i++)
            {
                int ver=pq.poll();
                for(int nei:adj.get(ver))
                {
                    maxT[nei]=Math.max(maxT[nei],maxT[ver]+time[nei-1]);
                    indegree[nei]--;
                    if(indegree[nei]==0)
                        pq.offer(nei);
                }
            }
        }
        int ans=0;
        for(int m:maxT)
            ans=Math.max(ans,m);
        return ans;
    }
}