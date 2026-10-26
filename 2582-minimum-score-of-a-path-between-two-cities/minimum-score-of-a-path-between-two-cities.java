class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] r:roads)
        {
            adj.get(r[0]-1).add(new int[]{r[1]-1,r[2]});
            adj.get(r[1]-1).add(new int[]{r[0]-1,r[2]});
        }
        ArrayDeque<Integer> q=new ArrayDeque<>();
        Set<Integer> v=new HashSet<>();
        q.offer(0);
        v.add(0);
        int minm=Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int curr=q.poll();
                for(int[] nei:adj.get(curr))
                {
                    minm=Math.min(minm,nei[1]);
                    if(!v.contains(nei[0]))
                    {
                        q.offer(nei[0]);
                        v.add(nei[0]);
                    }
                }
            }
        }
        return minm;
    }
}