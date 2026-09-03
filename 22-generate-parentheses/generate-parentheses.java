class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backtrack(0,0,new StringBuilder(),n,ans);
        return ans;
    }
    public void backtrack(int open,int close,StringBuilder sb,int n,List<String> ans)
    {
        if(close>n || open>n) return;
        if(open==close && open==n)
        {
            ans.add(sb.toString());
            return;
        }
        if(open<n)
        {
            sb.append("(");
            backtrack(open+1,close,sb,n,ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open)
        {
            sb.append(")");
            backtrack(open,close+1,sb,n,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}