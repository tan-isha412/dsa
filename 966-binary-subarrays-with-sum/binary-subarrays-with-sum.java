class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,1);
        int psum=0,cnt=0;
        for(int n:nums)
        {
            psum+=n;
            if(m.containsKey(psum-goal))
                cnt+=m.get(psum-goal);
            m.put(psum,m.getOrDefault(psum,0)+1);
        }
        return cnt;
    }
}