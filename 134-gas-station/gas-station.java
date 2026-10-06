class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int currnet=0,totalnet=0;
        for(int i=0;i<gas.length;i++)
        {
            currnet+=gas[i]-cost[i];
            totalnet+=gas[i]-cost[i];
            if(currnet<0)
            {
                start=i+1;
                currnet=0;
            }
        }
        if(totalnet<0) return -1;
        return start;
    }
}