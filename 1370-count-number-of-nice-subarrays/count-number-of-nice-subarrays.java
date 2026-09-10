class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    public int atmost(int[] nums,int k)
    {
        int l=0,cnt=0,ans=0;
        for(int r=0;r<nums.length;r++)
        {
            if(nums[r]%2==1) cnt++;
            while(cnt>k)
            {
                if(nums[l]%2==1)
                    cnt--;
                l++;
            }
            ans+=(r-l+1);
        }
        return ans;
    }
}