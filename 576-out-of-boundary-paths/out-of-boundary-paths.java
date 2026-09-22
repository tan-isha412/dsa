class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int M = 1000000007;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;
        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};
        while(maxMove>0)
        {
            int[][] nextDp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int nr = i + r[k];
                            int nc = j + c[k];
                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                count = (count + dp[i][j]) % M;
                            } else {
                                nextDp[nr][nc] = (nextDp[nr][nc] + dp[i][j]) % M;
                            }
                        }
                    }
                }
            }
            dp = nextDp; // Move to the next step
            maxMove--;
        }
        
        return count;
    }
}
