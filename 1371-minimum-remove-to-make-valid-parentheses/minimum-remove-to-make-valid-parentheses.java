class Solution {
    public String minRemoveToMakeValid(String s) {
        ArrayDeque<Integer> st=new ArrayDeque<>();
        ArrayDeque<Integer> close=new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(!Character.isLetter(ch))
            {
                if(ch=='(')
                    st.push(i);
                else
                {
                    if(!st.isEmpty())
                        st.pop();
                    else
                        close.push(i);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!st.isEmpty())
            ans.add(st.pop());
        while(!close.isEmpty())
            ans.add(close.pop());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(!ans.contains(i))
                sb.append(s.charAt(i));
        }        
        return sb.toString();
    }
}