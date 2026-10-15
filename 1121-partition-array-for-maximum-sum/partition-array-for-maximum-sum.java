class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            int currmax=0;
            for(int len=1;len<=k && i-len>=0;len++)
            {
                currmax=Math.max(currmax,arr[i-len]);
                dp[i]=Math.max(dp[i],dp[i-len]+currmax*len);
            }
        }
        return dp[n];
    }
}
