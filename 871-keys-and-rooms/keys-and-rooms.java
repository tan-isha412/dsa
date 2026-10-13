class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] canVis=new boolean[n];
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.offer(0);
        canVis[0]=true;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            for(int nei:rooms.get(curr))
            {
                if(!canVis[nei])
                {
                    canVis[nei]=true;
                    q.offer(nei);
                }
            }
        }
        for(boolean c:canVis)
        {
            if(!c) return false;
        }
        return true;
    }
}