class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        return Math.max(helper(nums,0,n-2),helper(nums,1,n-1));
    }
    public int helper(int[] nums,int l,int r)
    {
        int first=nums[l],second=Math.max(nums[l],nums[l+1]);
        for(int i=l+2;i<=r;i++)
        {
            int curr=Math.max(second,nums[i]+first);
            first=second;
            second=curr;
        }
        return second;
    }
}