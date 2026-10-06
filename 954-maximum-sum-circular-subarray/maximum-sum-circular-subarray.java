class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalsum=nums[0],currmax=nums[0],amax=nums[0],currmin=nums[0],amin=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            currmin=Math.min(nums[i],currmin+nums[i]);
            amin=Math.min(amin,currmin);
            currmax=Math.max(nums[i],currmax+nums[i]);
            amax=Math.max(amax,currmax);
            totalsum+=nums[i];
        }
        if(amax<0) return amax;
        return Math.max(amax,totalsum-amin);
    }
}