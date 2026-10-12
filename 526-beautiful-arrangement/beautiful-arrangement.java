class Solution {
    int cnt=0;
    public int countArrangement(int n) {
        backtrack(1,n,new boolean[n]);
        return cnt;
    }
    public void backtrack(int idx,int n,boolean[] b)
    {
        if(idx>n)
        {
            cnt++;
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if((i%idx==0 || idx%i==0) && !b[i-1])
            {
                b[i-1]=true;
                backtrack(idx+1,n,b);
                b[i-1]=false;
            }
        }
    }
}