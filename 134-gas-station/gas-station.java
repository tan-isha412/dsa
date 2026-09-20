class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currt=0,total=0,start=0;
        for(int i=0;i<gas.length;i++)
        {
            int net=gas[i]-cost[i];
            total+=net;
            currt+=net;
            if(currt<0)
            {
                start=i+1;
                currt=0;
            }
        }
        return total<0?-1:start;
    }
}