class Solution {
    public boolean isInterleave(String s1, String s2, String s3) 
    {
        int m=s1.length();
        int n=s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] b=new boolean[m+1][n+1];
        b[0][0]=true;
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if (i == 0 && j == 0) 
                    continue;
                b[i][j]=(i>0 && b[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1))||(j>0 && b[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1));
            }
        }
        return b[m][n];
    }
}