class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        if(n<1) return true;
        int minm=Integer.MAX_VALUE,maxm=0;
        for(int[] t:trips)
        {
            minm=Math.min(minm,t[1]);
            maxm=Math.max(maxm,t[2]);
        }
        int[] cap=new int[maxm-minm+1];
        for(int[] t:trips)
        {
            cap[t[1]-minm]+=t[0];
            cap[t[2]-minm]-=t[0];
        }
        int sum=0;
        for(int c:cap)
        {
            sum+=c;
            if(sum>capacity) return false;
        }
        return true;
    }
}