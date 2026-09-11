class Solution {
    public int maxDistance(int[] position, int m) {
        int minm=1,maxm=-1,ans=-1;
        for(int p:position)
        {
            if(p>maxm) maxm=p;
        }
        Arrays.sort(position);
        while(minm<=maxm)
        {
            int mid=(minm+maxm)/2;
            if(canPlace(position,m-1,mid))
            {
                ans=mid;
                minm=mid+1;
            }
            else
                maxm=mid-1;
        }
        return ans;
    }
    public boolean canPlace(int[] position,int m,int mid)
    {
        int start=0;
        for(int i=1;i<position.length;i++)
        {
            if(position[i]-position[start]>=mid)
            {
                start=i;
                m--;
            }
        }
        return m<=0;
    }
}