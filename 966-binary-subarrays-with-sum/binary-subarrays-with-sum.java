class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,1);
        int prefix=0,cnt=0;
        for(int n:nums)
        {
            prefix+=n;
            if(m.containsKey(prefix-goal))
                cnt+=m.get(prefix-goal);
            m.put(prefix,m.getOrDefault(prefix,0)+1);
        }
        return cnt;
    }
}