class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxm=days[days.length-1];
        int[] dp=new int[maxm+1];
        boolean[] travDay=new boolean[maxm+1];
        for(int d:days)
            travDay[d]=true;
        for(int i=1;i<=maxm;i++)
        {
            if(travDay[i])
                dp[i]=Math.min(dp[Math.max(0,i-30)]+costs[2],Math.min(dp[i-1]+costs[0],dp[Math.max(0,i-7)]+costs[1]));
            else
                dp[i]=dp[i-1];
        }
        return dp[maxm];
    }
}