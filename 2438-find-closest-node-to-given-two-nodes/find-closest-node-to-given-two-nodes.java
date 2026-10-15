class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[] d1=new int[n];
        int[] d2=new int[n];
        Arrays.fill(d1,-1);
        Arrays.fill(d2,-1);
        bfs(edges,d1,node1);
        bfs(edges,d2,node2);
        int minmaxdist=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++)
        {
            if(d1[i]!=-1 && d2[i]!=-1)
            {
                int currmax=Math.max(d1[i],d2[i]);
                if(currmax<minmaxdist)
                {
                    minmaxdist=currmax;
                    ans=i;
                }
            }
        }
        return ans;
    }
    public void bfs(int[] e,int[] d,int start)
    {
        int currd=0;
        while(start!=-1 && d[start]==-1)
        {
            d[start]=currd;
            currd++;
            start=e[start];
        }
    }
}