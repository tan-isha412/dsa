class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++)
        {
            if(manager[i]!=-1)
                adj.get(manager[i]).add(new int[]{i,informTime[manager[i]]});
        }
        ArrayDeque<int[]> q=new ArrayDeque<>();
        Set<Integer> v=new HashSet<>();
        q.offer(new int[]{headID,0});
        v.add(headID);
        int maxm=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int[] curr=q.poll();
                for(int[] nei:adj.get(curr[0]))
                {
                    if(!v.contains(nei[0]))
                    {
                        q.offer(new int[]{nei[0],curr[1]+nei[1]});
                        v.add(nei[0]);
                        maxm=Math.max(maxm,curr[1]+nei[1]);
                    }
                }
            }
        }
        return maxm;
    }
}