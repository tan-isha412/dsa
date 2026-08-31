class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1) return 0;
        int n=nums.length,farthest=0,currend=0,jumps=0;
        for(int i=0;i<nums.length;i++)
        {
            farthest=Math.max(farthest,i+nums[i]);
            if(farthest>=n-1) return jumps+1;
            if(i==currend)
            {
                jumps++;
                currend=farthest;
            }
        }
        return -1;
    }
}