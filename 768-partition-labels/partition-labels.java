class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        for(int i=0;i<s.length();i++)
            last[s.charAt(i)-'a']=i;
        List<Integer> ans=new ArrayList<>();
        int start=0,currend=0;
        for(int i=0;i<s.length();i++)
        {
            currend=Math.max(currend,last[s.charAt(i)-'a']);
            if(currend==i)
            {
                ans.add(currend-start+1);
                start=i+1;
            }
        }
        return ans;
    }
}