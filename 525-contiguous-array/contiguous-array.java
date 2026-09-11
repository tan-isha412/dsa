class Solution {
    int[] val={-1,1};
    public int findMaxLength(int[] nums) {
        int prefixsum=0,maxlen=0;
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            prefixsum+=val[nums[i]];
            if(m.containsKey(prefixsum))
                maxlen=Math.max(maxlen,i-m.get(prefixsum));
            else
                m.put(prefixsum,i);
        }
        return maxlen;
    }
}