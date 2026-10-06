class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        Arrays.fill(res,1);
        int pro=1;
        for(int i=1;i<nums.length;i++)
        {
            pro*=nums[i-1];
            res[i]*=pro;
        }
        pro=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            pro*=nums[i+1];
            res[i]*=pro;
        }
        return res;
    }
}