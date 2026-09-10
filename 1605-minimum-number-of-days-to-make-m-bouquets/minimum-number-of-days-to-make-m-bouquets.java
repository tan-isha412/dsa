class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m * k > bloomDay.length) return -1;         
        int l=Integer.MAX_VALUE,r=0;
        for(int b:bloomDay)
        {
            if(b>r)
                r=b;
            if(b<l)
                l=b;
        }
        int ans=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(canMake(bloomDay,m,k,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        return ans;
    }
    public boolean canMake(int[] bloomDay, int m, int k,int d)
    {
        int curr=0;
        for(int b:bloomDay)
        {
            if(b<=d)
            {
                curr++;
                if(curr==k)
                {
                    m--;
                    curr=0;
                }
                if(m==0) return true;
            }
            else
                curr=0;
        }
        return false;
    }
}