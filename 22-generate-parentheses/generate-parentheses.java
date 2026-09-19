class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n,0,0,"");
        return ans;
    }
    public void backtrack(int n,int open,int close,String s)
    {
        if(open==close && open==n)
        {
            ans.add(s);
            return;
        }
        if(open<n)
            backtrack(n,open+1,close,s+"(");
        if(close<open)
            backtrack(n,open,close+1,s+")");
    }
}