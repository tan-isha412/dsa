class Solution {
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        int maxm=position[n-1]-position[0];
        int l=0,r=maxm,ans=0;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(possible(position,m,mid))
            {
                ans=mid;
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return ans;
    }
    public boolean possible(int[] position,int m,int mid)
    {
        int count=1,lastplaced=position[0];
        for(int i=1;i<position.length;i++)
        {
            if(position[i]-lastplaced>=mid)
            {
                count++;
                lastplaced=position[i];
            }
        }
        return count>=m;
    }
}