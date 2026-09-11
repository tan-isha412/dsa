class Solution {
    int cnt=0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,0,target,0);
        return cnt;
    }
    public void backtrack(int[] nums,int idx,int target,int currsum)
    {
        if(idx==nums.length)
        {
            if(currsum==target) 
                cnt++;
            return;
        }
        backtrack(nums,idx+1,target,currsum+nums[idx]);
        backtrack(nums,idx+1,target,currsum-nums[idx]);
    }

}