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
        q.offer(new int[]{headID,0});
        int maxm=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int[] curr=q.poll();
                maxm=Math.max(maxm,curr[1]);
                for(int[] nei:adj.get(curr[0]))
                    q.offer(new int[]{nei[0],curr[1]+nei[1]});
            }
        }
        return maxm;
    }
}