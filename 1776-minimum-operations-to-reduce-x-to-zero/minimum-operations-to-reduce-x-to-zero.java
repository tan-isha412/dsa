class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0,maxlen=-1,l=0;
        for(int n:nums) sum+=n;
        if(sum<x) return -1;
        sum-=x;
        int currsum=0;
        for(int r=0;r<nums.length;r++)
        {
            currsum+=nums[r];
            while(currsum>sum)
                currsum-=nums[l++];
            if(currsum==sum)
                maxlen=Math.max(maxlen,r-l+1);
        }
        if(maxlen==-1) return -1;
        return nums.length-maxlen;
    }
}