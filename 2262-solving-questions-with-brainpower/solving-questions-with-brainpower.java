class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            int cmp=Math.min(n,i+questions[i][1]+1);
            dp[i]=Math.max(dp[i+1],dp[cmp]+questions[i][0]);
        }
        return dp[0];
    }
}