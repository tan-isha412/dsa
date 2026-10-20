class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] c:connections)
        {
            adj.get(c[0]).add(new int[]{c[1],1});
            adj.get(c[1]).add(new int[]{c[0],0});
        }
        ArrayDeque<Integer> q=new ArrayDeque<>();
        Set<Integer> s=new HashSet<>();
        int cost=0;
        q.offer(0);
        s.add(0);
        while(!q.isEmpty())
        {
            int curr=q.poll();
            for(int[] nei:adj.get(curr))
            {
                if(!s.contains(nei[0]))
                {
                    cost+=nei[1];
                    q.offer(nei[0]);
                    s.add(nei[0]);
                }
            }
        }
        return cost;
    }
}