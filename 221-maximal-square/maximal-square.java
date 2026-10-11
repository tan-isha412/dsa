class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxm=0;
        int r=matrix.length,c=matrix[0].length;
        int[][] dp=new int[r+1][c+1];
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=c;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    int minm=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                    maxm=Math.max(maxm,minm);
                    dp[i][j]=minm;
                }
            }
        }
        return maxm*maxm;
    }
}