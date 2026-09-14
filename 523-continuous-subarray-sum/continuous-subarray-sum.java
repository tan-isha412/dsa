class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,-1);
        int prefixsum=0,maxlen=0;
        for(int i=0;i<nums.length;i++)
        {
            prefixsum+=nums[i];
            int rem=prefixsum%k;
            if(rem<0) rem+=k;
            if(m.containsKey(rem))
                maxlen=Math.max(maxlen,i-m.get(rem));
            else
                m.put(rem,i);
        }
        return maxlen>=2;
    }
}