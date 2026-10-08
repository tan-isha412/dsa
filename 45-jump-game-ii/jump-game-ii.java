class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        dp[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--)
        {
            dp[i]=nums.length+1;
            for(int j=i+1;j<=i+nums[i];j++)
            {
                if(j>nums.length-1) continue;
                dp[i]=Math.min(dp[i],dp[j]+1);
            }
        }
        return dp[0];
    }
}