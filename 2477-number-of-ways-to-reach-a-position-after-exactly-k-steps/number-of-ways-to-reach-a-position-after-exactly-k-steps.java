class Solution {
    int MOD = 1000000007;
    
    public int numberOfWays(int startPos, int endPos, int k) {
        if (Math.abs(startPos - endPos) > k || (k - Math.abs(startPos - endPos)) % 2 != 0) {
            return 0;
        }
        int minm = startPos - k;
        int maxm = startPos + k;
        int diff = maxm - minm;
        
        int[][] dp = new int[k + 1][diff + 1];
        dp[0][startPos - minm] = 1;
        
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= diff; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                }
                if (j + 1 <= diff) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }
        
        return dp[k][endPos - minm];
    }
}
