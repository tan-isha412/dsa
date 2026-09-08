class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        if(n<0) return 0;
        Arrays.sort(nums);
        int low=nums[0],high=nums[n-1];
        int[] diff=new int[high-low+1];
        for(int num:nums)
            diff[num-low]+=num;
        if(diff.length==1) return diff[0];
        int first=diff[0],second=Math.max(diff[0],diff[1]),maxm=second;
        for(int i=2;i<diff.length;i++)
        {
            maxm=Math.max(first+diff[i],second);
            first=second;
            second=maxm;
        }
        return second;
    }
}