class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> subord=new ArrayList<>();
        for(int i=0;i<n;i++)
            subord.add(new ArrayList<>());
        for(int i=0;i<n;i++)
        {   
            if(manager[i]!=-1)
                subord.get(manager[i]).add(i);
        }
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{headID,0});
        int maxm=0;
        while(!q.isEmpty())
        {
            int[] curboss=q.poll();
            maxm=Math.max(maxm,curboss[1]);
            if(subord.get(curboss[0]).size()==0)
                continue;
            for(int nei:subord.get(curboss[0]))
                q.offer(new int[]{nei,curboss[1]+informTime[curboss[0]]});
        }
        return maxm;
    }
}