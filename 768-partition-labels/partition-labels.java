class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int[] lastin=new int[26];
        for(int i=0;i<s.length();i++)
            lastin[s.charAt(i)-'a']=i;
        int farthest=0,l=0,r=0;
        while(r<s.length())
        {
            farthest=Math.max(farthest,lastin[s.charAt(r)-'a']);
            if(farthest==r)
            {
                ans.add(r-l+1);
                l=r+1;  
            }
            r++;
        }
        return ans;
    }
}