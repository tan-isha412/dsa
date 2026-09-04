class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] f:flights)
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{src,0});
        int stops=0;
        while(!q.isEmpty() && stops<=k)
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int[] curr=q.poll();
                for(int[] nei:adj.get(curr[0]))
                {
                    if(curr[1]+nei[1]<dist[nei[0]])
                    {
                        dist[nei[0]]=curr[1]+nei[1];
                        q.offer(new int[]{nei[0],dist[nei[0]]});
                    }
                }
            }
            stops++;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}