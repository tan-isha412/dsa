class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        backtrack(0,s,ans,new ArrayList<>());
        return ans;
    }
    public void backtrack(int start,String s,List<List<String>> ans,List<String> l)
    {
        if(start==s.length())
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=start;i<s.length();i++)
        {
            String temp=s.substring(start,i+1);
            if(palin(temp))
            {
                l.add(temp);
                backtrack(i+1,s,ans,l);
                l.remove(l.size()-1);
            }
        }
    }
    public boolean palin(String s)
    {
        int l=0,r=s.length()-1;
        while(l<=r && s.charAt(l)==s.charAt(r))
        {
            l++;
            r--;
        }
        return l>r;
    }
}