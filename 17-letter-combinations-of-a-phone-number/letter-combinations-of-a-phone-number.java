class Solution {
    String[] tele={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        backtrack(0,digits,new StringBuilder(),ans);
        return ans;
    }
    public void backtrack(int idx,String digits,StringBuilder sb,List<String> ans)
    {
        if(idx==digits.length())
        {
            ans.add(sb.toString());
            return;
        }
        for(char ch:tele[digits.charAt(idx)-'0'].toCharArray())
        {
            sb.append(ch);
            backtrack(idx+1,digits,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}