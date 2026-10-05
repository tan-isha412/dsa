class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,((a,b)->a[0]-b[0]));
        ArrayList<int[]> arr=new ArrayList<>();
        int start=intervals[0][0],end=intervals[0][1];
        int i=1;
        while(i<intervals.length)
        {
            if(end>=intervals[i][0])
                end=Math.max(end,intervals[i][1]);
            else
            {
                arr.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
            i++;
        }
        arr.add(new int[]{start,end});
        int[][] merged=new int[arr.size()][2];
        for(i=0;i<arr.size();i++)
        {
            merged[i][0]=arr.get(i)[0];
            merged[i][1]=arr.get(i)[1];
        }
        return merged;
    }
}