class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1,r=nums.length-1;
            while(l<=r)
            {
                int mid=l+(r-l)/2;
                if(nums[mid]==k+nums[i])
                {
                    sum++;
                    break;
                }
                else if(nums[mid]>k+nums[i])
                    r=mid-1;
                else
                    l=mid+1;
            }
        }
        return sum;
    }
}