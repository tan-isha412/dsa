class Solution {
    public int longestArithSeqLength(int[] nums) {
        int len=nums.length;
        int minm=501,maxm=-1;
        for(int n:nums)
        {
            if(minm>n) minm=n;
            if(maxm<n) maxm=n;
        }
        int diff=maxm-minm;
        int[][] dp=new int[len+1][2*diff+1];
        for(int i=1;i<=len;i++)
            Arrays.fill(dp[i],1);
        
        int maxLen = 1; 
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int d = nums[i] - nums[j] + diff;
                dp[i + 1][d] = Math.max(dp[i + 1][d], 1 + dp[j + 1][d]);
                maxLen = Math.max(maxLen, dp[i + 1][d]);
            }
        }
        return maxLen;
    }
}