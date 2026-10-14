class Solution {
    public int removeDuplicates(int[] nums) {
        //slow fast pointer
        int slow=0;
        int fast=1;
        while(fast<nums.length)
        {
            if(nums[slow]!=nums[fast])
            {
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}