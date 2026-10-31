class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] b : bookings) {
            int start = b[0] - 1; 
            int end = b[1];       
            int seats = b[2];
            
            ans[start] += seats;
            if (end < n) {
                ans[end] -= seats;
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        
        return ans;
    }
}
