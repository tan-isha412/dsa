class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]-nums[i]==k)
                {
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }
}