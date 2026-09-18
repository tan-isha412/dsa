class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,sum=0,minlen=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(sum>=target)
            {
                minlen=Math.min(minlen,i-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}