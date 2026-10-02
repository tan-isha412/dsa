class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int c:coins)
        {
            for(int i=c;i<=amount;i++)
            {
                if(dp[i-c]!=amount+1)
                    dp[i]=Math.min(dp[i-c]+1,dp[i]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}