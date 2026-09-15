class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> st=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        String[] dir=path.split("/");
        for(String d:dir)
        {
            if(!d.equals("") && !d.equals("."))
            {
                if(d.equals(".."))
                {
                    if(!st.isEmpty())
                        st.pop();
                }
                else
                    st.push(d);
            }
        }
        while(!st.isEmpty())
        {
            String in="/"+st.pop();
            sb.insert(0,in);
        }
        return sb.length()==0?"/":sb.toString();
    }
}