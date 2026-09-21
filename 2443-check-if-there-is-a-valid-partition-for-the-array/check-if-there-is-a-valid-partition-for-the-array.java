class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp=new boolean[nums.length+1];
        dp[0]=true;
        for(int i=2;i<=nums.length;i++)
        {
            if(nums[i-1]==nums[i-2])
                dp[i]|=dp[i-2];
            if(i>=3 && nums[i-3]==nums[i-2] && nums[i-1]==nums[i-2])
                dp[i]|=dp[i-3];
            if(i>=3 && nums[i-3]+1==nums[i-2] && nums[i-2]+1==nums[i-1])
                dp[i]|=dp[i-3];
        }
        return dp[nums.length];
    }
}