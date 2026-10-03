class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb=new StringBuilder();
        ArrayDeque<Integer> st2=new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(sb.length()>0 && sb.charAt(sb.length()-1)==ch)
            {
                int newc=st2.peek()+1;
                sb.append(ch);
                st2.pop();
                st2.push(newc);
                if(newc==k)
                {
                    sb=sb.delete(sb.length()-k,sb.length());
                    st2.pop();
                }
            }
            else
            {
                sb.append(ch);
                st2.push(1);
            }
        }
        return sb.toString();
    }
}