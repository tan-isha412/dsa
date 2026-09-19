class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int l=0,r=nums.length-1,a=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(nums[mid]>=target)
            {
                a=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        if(a==-1 || (a!=-1 && nums[a]!=target))
            return new int[]{-1,-1};
        ans[0]=a;
        l=0;
        a=-1;
        r=nums.length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(nums[mid]<=target)
            {
                a=mid;
                l=mid+1;
            }
            else
                r=mid-1;
        }
        ans[1]=a;
        return ans;
    }
}