class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,1);
        int c=0;
        int prefixsum=0;
        for(int n:nums)
        {
            prefixsum+=n;
            if(m.containsKey(prefixsum-k))
                c+=m.get(prefixsum-k);
            m.put(prefixsum,m.getOrDefault(prefixsum,0)+1);
        }
        return c;
    }
}