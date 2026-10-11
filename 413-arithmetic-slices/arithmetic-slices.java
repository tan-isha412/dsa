class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2) return 0;
        int diff=nums[1]-nums[0];
        int len=2,l=0,cnt=0;
        for(int r=2;r<nums.length;r++)
        {
            if(diff!=nums[r]-nums[r-1])
            {
                diff=nums[r]-nums[r-1];
                l=r-1;
                len=2;
            }
            else
            {
                len++;
                if(len>=3)
                    cnt+=(r-l-1);
            }
        }
        return cnt;
    }
}