class Solution {
    public int maxSubArray(int[] nums) {
        int cursum=0,maxsum=Integer.MIN_VALUE;
        for(int n:nums)
        {
            cursum=Math.max(n,cursum+n);
            maxsum=Math.max(cursum,maxsum);
        }
        return maxsum;
    }
}