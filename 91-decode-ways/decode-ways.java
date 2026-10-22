class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        dp[s.length()]=1;
        for(int i=s.length()-1;i>=0;i--)
        {
            dp[i]=dp[i+1];
            if(s.charAt(i)=='0')
                dp[i]=0;
            if(i<s.length()-1)
            {
                int val=Integer.parseInt(s.substring(i,i+2));
                if(val>=10 && val<=26)
                    dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }
}