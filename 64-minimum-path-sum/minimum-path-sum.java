class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        int sum=0;
        for(int i=0;i<m;i++)
        {
            sum+=grid[i][0];
            ans[i][0]=sum;
        }
        sum=grid[0][0];
        for(int i=1;i<n;i++)
        {
            sum+=grid[0][i];
            ans[0][i]=sum;
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
                ans[i][j]=Math.min(ans[i-1][j],ans[i][j-1])+grid[i][j];
        }
        return ans[m-1][n-1];
    }
}