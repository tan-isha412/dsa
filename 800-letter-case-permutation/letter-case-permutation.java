class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> l=new ArrayList<>();
        backtrack(0,s,new StringBuilder(),l);
        return l;
    }
    public void backtrack(int i,String s,StringBuilder res,List<String> l)
    {
        if(i==s.length())
        {
            l.add(res.toString());
            return;
        }
        int len=res.length();
        char ch=s.charAt(i);
        if(Character.isLetter(ch))
        {
            backtrack(i+1,s,res.append(Character.toUpperCase(ch)),l);
            res.setLength(len);
            backtrack(i+1,s,res.append(Character.toLowerCase(ch)),l);
            res.setLength(len);
        }
        else{
            res.append(ch); 
            backtrack(i+1,s,res,l);
            res.setLength(len);
        }
    }
}