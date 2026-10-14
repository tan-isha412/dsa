class Solution {
    public String longestPalindrome(String s) {
        String maxstr="";
        int maxlen=0;
        for(int i=0;i<s.length();i++)
        {
            String oddstr=palin(s,i,i);
            String evenstr=palin(s,i,i+1);
            if(oddstr.length()>evenstr.length())
                evenstr=oddstr;
            if(evenstr.length()>maxlen){
                maxlen=evenstr.length();
                maxstr=evenstr;
            }
        }
        return maxstr;
    }
    public String palin(String s,int start1,int start2)
    {
        if(start2>=s.length() || s.charAt(start1)!=s.charAt(start2)) return s.substring(start1,start1+1);
        while(start1>0 && start2<s.length()-1 && s.charAt(start1-1)==s.charAt(start2+1))
        {
            start1--;
            start2++;
        }
        return s.substring(start1,start2+1);
    }
}