class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int[][] newint=new int[n][4];
        for(int i=0;i<n;i++)
        {
            newint[i][0]=intervals[i][0];
            newint[i][1]=intervals[i][1];
            newint[i][2]=i;
        }
        Arrays.sort(newint,((a,b)->Integer.compare(a[0],b[0])));
        for(int i=0;i<n;i++)
        {
            int l=i,r=n-1;
            int ans=-1;
            while(l<=r)
            {
                int mid=(l+r)/2;
                if(newint[mid][0]>=newint[i][1])
                {
                    ans=newint[mid][2];
                    r=mid-1;
                }
                else
                    l=mid+1;
            }
            newint[i][3]=ans;
        }
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[newint[i][2]]=newint[i][3];
        return a;
    }
}