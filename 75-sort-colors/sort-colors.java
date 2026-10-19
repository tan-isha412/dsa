class Solution {
    public void sortColors(int[] nums) {
        int z=0,o=0,t=nums.length-1;
        while(o<=t)
        {
            if(nums[o]==0)
            {
                int temp=nums[z];
                nums[z]=nums[o];
                nums[o]=temp;
                z++;
                o++;
            }         
            else if(nums[o]==1)
                o++;
            else
            {
                int temp=nums[o];
                nums[o]=nums[t];
                nums[t]=temp;
                t--;
            }
        }
    }
}