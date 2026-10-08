class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int currtarg=0,farthest=0,jumps=0;
        for(int i=0;i<nums.length;i++)
        {
            farthest=Math.max(farthest,i+nums[i]);
            if(farthest>=nums.length-1) return jumps+1;
            if(currtarg==i)
            {
                jumps++;
                currtarg=farthest;
            }
        }
        return -1;
    }
}