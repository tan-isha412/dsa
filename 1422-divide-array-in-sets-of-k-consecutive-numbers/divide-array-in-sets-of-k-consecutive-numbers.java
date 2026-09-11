class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        Arrays.sort(nums);
        Map<Integer,Integer> m=new HashMap<>();
        for(int n:nums)
            m.put(n,m.getOrDefault(n,0)+1);
        for(int n:nums)
        {
            if(!m.containsKey(n)) continue;
            int start=n,len=0;
            while(len<k && m.containsKey(start+len) && m.get(start+len)>0)
            {
                m.put(start+len,m.get(start+len)-1);
                if(m.get(start+len)==0)
                    m.remove(start+len);
                len++;
            }
            if(len<k) return false;
        }
        return true;
    }
}