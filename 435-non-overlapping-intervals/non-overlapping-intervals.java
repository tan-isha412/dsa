class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,((a,b)->a[1]-b[1]));
        int lastend=intervals[0][1],removed=0;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]>=lastend)
                lastend=intervals[i][1];
            else
                removed++;
        }
        return removed;
    }
}