class Solution {
    int[] actv={-1,1};
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,-1);
        int sum=0,maxlen=0;
        for(int r=0;r<nums.length;r++)
        {
            sum+=actv[nums[r]];
            if(m.containsKey(sum))
                maxlen=Math.max(maxlen,r-m.get(sum));
            else
                m.put(sum,r);
        }
        return maxlen;
    }
}