class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> m=new HashMap<>();
        int l=0,maxlen=0;
        for(int r=0;r<s.length();r++)
        {
            m.put(s.charAt(r),m.getOrDefault(s.charAt(r),0)+1);
            while(l<r && m.get(s.charAt(r))>1)
                m.put(s.charAt(l),m.get(s.charAt(l++))-1);
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}