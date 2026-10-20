class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,-1);
        int psum=0,maxlen=0;
        for(int i=0;i<nums.length;i++)
        {
            psum+=nums[i];
            int rem=psum%k;
            if(rem<0) rem+=k;
            if(m.containsKey(rem))
            {
                if(maxlen<i-m.get(rem))
                    maxlen=i-m.get(rem);
                if(maxlen>=2) return true;
            }
            else
                m.put(rem,i);
        }
        return false;
    }
}