class Solution {
    public int minOperations(int[] nums, int x) 
    {
        int totsum=0;
        for(int n:nums)
            totsum+=n;
        int targ=totsum-x;
        if(targ==0) return nums.length;
        if(targ<0) return -1;
        int curr=0,l=0,maxlen=Integer.MIN_VALUE;
        for(int r=0;r<nums.length;r++)
        {
            curr+=nums[r];
            while(l<=r && curr>targ)
                curr-=nums[l++];
            if(curr==targ)
                maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen==Integer.MIN_VALUE?-1:nums.length-maxlen;
    }
}