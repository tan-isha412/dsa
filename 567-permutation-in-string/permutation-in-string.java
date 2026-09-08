class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int n1=s1.length();
        int n2=s2.length();
        char[] c1=s1.toCharArray();
        Arrays.sort(c1);
        for(int i=0;i<=n2-n1;i++)
        {
            char[] c2=s2.substring(i,i+n1).toCharArray();
            Arrays.sort(c2);
            if(Arrays.equals(c1,c2))
                return true;
        }
        return false;
    }
}