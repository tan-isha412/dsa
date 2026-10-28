class Solution {
    public long subArrayRanges(int[] nums) {
        long diff=0;
        for(int i=0;i<nums.length;i++)
        {
            long ans=calcD(i,nums[i],nums[i],nums);
            diff+=ans;
        }
        return diff;
    }
    public long calcD(int idx,int minm,int maxm,int[] nums)
    {
        if(idx==nums.length)
            return 0;
        minm=Math.min(minm,nums[idx]);
        maxm=Math.max(maxm,nums[idx]);
        long ans=0;
        ans+=maxm-minm;
        ans+=calcD(idx+1,minm,maxm,nums);
        return ans;
    }
}