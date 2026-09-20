class Solution {
    int maxlen=0;
    public int maxLength(List<String> arr) {
        backtrack(0,arr,"");
        return maxlen;
    }
    public void backtrack(int idx,List<String> arr,String s)
    {
        if(idx==arr.size())
        {
            maxlen=Math.max(maxlen,s.length());
            return;
        }
        if(isValid(s,arr.get(idx)))
            backtrack(idx+1,arr,s+arr.get(idx));
        backtrack(idx+1,arr,s);
    }
    public boolean isValid(String s1,String s2)
    {
        Set<Character> s=new HashSet<>();
        for(char ch:s1.toCharArray())
        {
            if(s.contains(ch)) return false;
            s.add(ch);
        }
        for(char ch:s2.toCharArray())
        {
            if(s.contains(ch)) return false;
            s.add(ch);
        }
        return true;
    }
}