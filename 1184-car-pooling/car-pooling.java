class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxm=-1,minm=Integer.MAX_VALUE;
        for(int[] t:trips)
        {
            minm=Math.min(minm,t[1]);
            maxm=Math.max(maxm,t[2]);
        }
        int[] c=new int[maxm-minm+1];
        for(int[] t:trips)
        {
            c[t[1]-minm]+=t[0];
            c[t[2]-minm]-=t[0];
        }
        int sum=0;
        for(int cap:c)
        {
            sum+=cap;
            if(sum>capacity)
                return false;
        }
        return true;
    }
}