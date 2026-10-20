class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int l=0,cnt=0,ans=0;
        for(int r=0;r<nums.length;r++)
        {
            if(nums[r]%2==1) cnt++;
            while(l<r && cnt>k)
            {
                if(nums[l]%2==1) cnt--;
                l++;
            }
            if(cnt==k)
            {
                int og=l; 
                while(og<r && nums[og]%2==0)
                    og++;
                ans+=(og-l+1);
            }
        }
        return ans;
    }
}