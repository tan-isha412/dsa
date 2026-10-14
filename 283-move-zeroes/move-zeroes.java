class Solution {
    public void moveZeroes(int[] nums) {
        int z=0,nz=0;
        while(z<nums.length && nz<nums.length)
        {
            while(nz<nums.length && nums[nz]==0)
                nz++;
            while(z<nums.length && nums[z]!=0)
                z++;
            if(nz>z && nz<nums.length)
            {
                int temp=nums[z];
                nums[z]=nums[nz];
                nums[nz]=temp;
            }
            else
                nz++;

        }
    }
}