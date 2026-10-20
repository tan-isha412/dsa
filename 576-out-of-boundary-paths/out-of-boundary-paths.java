class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    if (maxMove == 0) return 0;
    
    int MOD = 1000000007;
    int[] r = {-1, 1, 0, 0};
    int[] c = {0, 0, -1, 1};
    
    int[][] dp = new int[m][n];
    dp[startRow][startColumn] = 1; 
    int tot = 0;
    
    for (int step = 0; step < maxMove; step++) {
        int[][] temp = new int[m][n];
        for (int j = 0; j < m; j++) 
        {
            for (int k = 0; k < n; k++) 
            {
                if (dp[j][k] > 0) 
                {
                    for (int l = 0; l < 4; l++) 
                    {
                        int newr = j + r[l];
                        int newc = k + c[l];
                        if (newr < 0 || newr >= m || newc < 0 || newc >= n) 
                            tot = (tot + dp[j][k]) % MOD;
                        else
                            temp[newr][newc] = (temp[newr][newc] + dp[j][k]) % MOD;
                    }
                }
            }
        }
        dp = temp;
    }
    return tot;
}
}