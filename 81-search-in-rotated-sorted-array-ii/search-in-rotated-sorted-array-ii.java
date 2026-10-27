class Solution {
    public boolean search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(sorted(nums,l,mid))
            {
                if(nums[l]==target || nums[mid]==target) return true;
                if(nums[mid]>target && nums[l]<target)
                    r=mid-1;
                else 
                    l=mid+1;
            }
            else
            {
                if(nums[r]==target || nums[mid]==target) return true;
                if(nums[mid]<target && nums[r]>target)
                    l=mid+1;
                else 
                    r=mid-1;
            }
        }
        return false;
    }
    public boolean sorted(int[] nums,int l,int r)
    {
        for(int i=l;i<r;i++)
        {
            if(nums[i]>nums[i+1]) return false;
        }
        return true;
    }
}