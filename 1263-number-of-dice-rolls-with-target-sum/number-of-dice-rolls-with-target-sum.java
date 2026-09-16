class Solution {
    int MOD=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for(int i=1;i<=target;i++)
        {
            if(i<=k)
                dp[1][i]=1;
        }
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                for (int face = 1; face <= k; face++) 
                {
                    if (j >= face) 
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - face]) % MOD;
                }
            }
        }
        return dp[n][target];
    }
}