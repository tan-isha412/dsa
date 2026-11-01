class Solution {
    int[] r={1,-1,0,0};
    int[] c={0,0,1,-1};
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        boolean[][][] v=new boolean[m][n][k+1];
        q.offer(new int[]{0,0,0});
        v[0][0][0]=true;
        int l=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int j=0;j<s;j++)
            {
                int[] curr=q.poll();
                if(curr[0]==m-1 && curr[1]==n-1) return l;
                for(int i=0;i<4;i++)
                {
                    int newr=curr[0]+r[i],newc=curr[1]+c[i];
                    if(newr<0 || newc<0 || newr>=m || newc>=n) continue;
                    int used = curr[2] + grid[newr][newc];
                    if (used > k || v[newr][newc][used])
                        continue;
                    v[newr][newc][used] = true;
                    q.offer(new int[]{newr, newc, used});
                }
            }
            l++;
        }
        return -1;
    }
}