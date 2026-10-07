class Solution {
    String[] values={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> l=new ArrayList<>();
        backtrack(0,digits,"",l);
        return l;
    }
    public void backtrack(int idx,String digits,String curr,List<String> l)
    {
        if(idx==digits.length())
        {
            l.add(curr);
            return;
        }
        int dig=digits.charAt(idx)-'0';
        for(int i=0;i<values[dig].length();i++)
            backtrack(idx+1,digits,curr+values[dig].charAt(i),l);
    }
}