class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,((a,b)->
        {
            return Integer.compare(a[1],b[1]);
        }));
        int end=points[0][1],i=1,b=1;
        while(i<points.length)
        {
            if(points[i][0]>end)
            {
                end=points[i][1];
                b++;
            }
            i++;
        }
        return b;
    }
}