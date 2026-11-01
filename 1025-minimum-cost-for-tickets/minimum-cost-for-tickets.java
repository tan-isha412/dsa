class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int last=days[n-1];
        int[] c=new int[last+1];
        boolean[] trav=new boolean[last+1];
        for(int d:days)
            trav[d]=true;
        for(int i=1;i<=last;i++)
        {
            if(!trav[i])
                c[i]=c[i-1];
            else
            {
                int c1=c[Math.max(0,i-1)]+costs[0];
                int c2=c[Math.max(0,i-7)]+costs[1];
                int c3=c[Math.max(0,i-30)]+costs[2];
                c[i]=Math.min(c1,Math.min(c2,c3));
            }
        }
        return c[last];
    }
}