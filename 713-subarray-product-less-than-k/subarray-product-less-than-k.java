class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod=1,l=0,cnt=0;
        for(int r=0;r<nums.length;r++)
        {
            prod*=nums[r];
            while(l<=r && prod>=k)
            {
                prod/=nums[l];
                l++;
            }
            cnt+=(r-l+1);
        }
        return cnt;
    }
}