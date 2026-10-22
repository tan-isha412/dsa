class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,((a,b)->a.length()-b.length()));
        Map<String,Integer> dp=new HashMap<>();
        int longest=1;
        for(String w:words)
        {
            int curr=1;
            for(int i=0;i<w.length();i++)
            {
                StringBuilder sb=new StringBuilder(w);
                sb.deleteCharAt(i);
                if(dp.containsKey(sb.toString()))
                    curr=Math.max(curr,dp.get(sb.toString())+1);
            }
            dp.put(w,curr);
            longest=Math.max(longest,curr);
        }
        return longest;
    }
}