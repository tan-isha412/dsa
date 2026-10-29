class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low=1,minTime=time[0];
        for(int t:time)
        {
            if(minTime>t) minTime=t;
        }
        long high=minTime*totalTrips;
        long ans=high;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canTravel(time,mid,totalTrips))
            {
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    public boolean canTravel(int[] time,long m,int totalTrips)
    {
        long ans=0;
        for(int t:time)
        {
            if(m>=t)
                ans+=m/t;
        }
        return ans>=totalTrips;
    }
}