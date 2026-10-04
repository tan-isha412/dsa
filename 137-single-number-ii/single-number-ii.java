class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int prevcand=nums[0],currcand;
        int len=0;
        for(int i=1;i<nums.length;i++)
        {
            currcand=nums[i];
            if(prevcand!=currcand)
            {
                if(len!=2) return prevcand;
            }
            len=(len+1)%3;
            prevcand=currcand;
        }
        return nums[nums.length-1];
    }
}