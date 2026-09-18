class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;
        for(int i=nums.length-1;i>0;i--)
        {
            if(nums[i]>nums[i-1])
            {
                idx=i-1;
                break;
            }
        }
        if(idx==-1)
        {
            rev(nums,0,nums.length-1);
            return;
        }
        int i=0;
        for(i=nums.length-1;i>idx;i--)
        {
            if(nums[i]>nums[idx])
                break;
        }
        swap(nums,idx,i);
        rev(nums,idx+1,nums.length-1);
    }
    public void swap(int[] nums,int l,int r)
    {
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
        return;
    }
    public void rev(int[] nums,int l,int r)
    {
        while(l<r)
        {
            swap(nums,l,r);
            l++;
            r--;
        }
    }
}