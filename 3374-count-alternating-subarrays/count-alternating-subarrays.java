class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int l=0;
        long cnt=0;
        for(int r=1;r<nums.length;r++)
        {
            if(nums[r-1]==1-nums[r]) continue;
            else
            {
                while(l<r)
                {
                    cnt+=(r-l);
                    l++;
                }
            }
        }
        while(l<nums.length)
        {
            cnt+=(nums.length-l);
            l++;
        }
        return cnt;
    }
}