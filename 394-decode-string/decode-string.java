class Solution {
    public String decodeString(String s) {
        ArrayDeque<Integer> numst=new ArrayDeque<>();
        ArrayDeque<String> ansst=new ArrayDeque<>();
        String curr="";
        int num=0;
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
                num=num*10+(ch-'0');
            else if(Character.isLetter(ch))
                curr+=String.valueOf(ch);
            else if(ch=='[')
            {
                numst.push(num);
                num=0;
                ansst.push(curr);
                curr="";
            }
            else
            {
                String anstillnow=ansst.pop();
                int freq=numst.pop();
                for(int i=0;i<freq;i++)
                    anstillnow+=curr;
                curr=anstillnow;
            }
        }
        return curr;
    }
}