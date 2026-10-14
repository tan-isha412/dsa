class Solution {
    int[] a={1,0};
    public int longestOnes(int[] nums, int k) {
        int maxlen=0,l=0;
        int sum=0;
        for(int r=0;r<nums.length;r++)
        {
            sum+=a[nums[r]];
            while(sum>k)
                sum-=a[nums[l++]];
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}