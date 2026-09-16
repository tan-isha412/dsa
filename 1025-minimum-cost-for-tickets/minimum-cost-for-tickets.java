class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxm=days[days.length-1];
        int[] dp=new int[maxm+1];
        dp[0]=0;
        boolean[] tday=new boolean[maxm+1];
        for(int d:days)
            tday[d]=true;
        for(int i=1;i<=maxm;i++)
        {
            if(!tday[i]) dp[i]=dp[i-1];
            else
            {
                int ch1=dp[Math.max(0,i-1)]+costs[0];
                int ch2=dp[Math.max(0,i-7)]+costs[1];
                int ch3=dp[Math.max(0,i-30)]+costs[2];
                dp[i]=Math.min(ch3,Math.min(ch1,ch2));
            }
        }
        return dp[maxm];
    }
}