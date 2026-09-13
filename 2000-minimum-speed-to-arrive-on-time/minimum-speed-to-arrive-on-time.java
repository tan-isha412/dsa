class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low=1,high=1000000000;
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(canReach(dist,hour,mid))
            {
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    public boolean canReach(int[] d,double h,int mid)
    {
        double hours=0.0;
        int i=0;
        while(i<d.length-1)
        {
            hours+=(d[i]+mid-1)/mid;
            i++;
        }
        hours += (double) d[i] / mid;
        return hours<=h;
    }
}