class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(String t:tokens)
        {
            int ans=0;
            if(t.equals("+"))
            {
                int op2=st.pop(),op1=st.pop();
                ans=op1+op2;
            }
            else if(t.equals("-"))
            {
                int op2=st.pop(),op1=st.pop();
                ans=op1-op2;
            }
            else if(t.equals("*"))
            {
                int op2=st.pop(),op1=st.pop();
                ans=op1*op2;
            }
            else if(t.equals("/"))
            {
                int op2=st.pop(),op1=st.pop();
                ans=op1/op2;
            }
            else
                ans=Integer.valueOf(t);
            st.push(ans);
        }
        return st.pop();
    }
}