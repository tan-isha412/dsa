class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans=new int[n];
        for(int[] b:bookings)
        {
            for(int i=b[0];i<=b[1];i++)
                ans[i-1]+=b[2];
        }
        return ans;
    }
}