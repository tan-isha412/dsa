class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        int ans=0;
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int[] c:connections)
        {
            adj.get(c[0]).add(new int[]{c[1],1});
            adj.get(c[1]).add(new int[]{c[0],0});
        }
        boolean[] v=new boolean[n];
        q.offer(0);
        v[0]=true;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            for(int[] nei:adj.get(curr))
            {
                if(!v[nei[0]])
                {
                    v[nei[0]]=true;
                    ans+=nei[1];
                    q.offer(nei[0]);
                }
            }
        }
        return ans;
    }
}