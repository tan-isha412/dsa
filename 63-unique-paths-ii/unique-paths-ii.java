class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length-1,n=obstacleGrid[0].length-1;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m][n]==1) return 0;
        int[][] dp=new int[m+1][n+1];
        dp[m][n]=1;
        for(int i=m-1;i>=0;i--)
        {
            if(obstacleGrid[i][n]==0)
                dp[i][n]=dp[i+1][n];
        }
        for(int i=n-1;i>=0;i--)
        {
            if(obstacleGrid[m][i]==0)
                dp[m][i]=dp[m][i+1];
        }
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(obstacleGrid[i][j]==0)
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}