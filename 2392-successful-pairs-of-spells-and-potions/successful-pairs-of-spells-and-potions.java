class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] a=new int[spells.length];
        for(int j=0;j<spells.length;j++)
        {
            int s=spells[j];
            int l=0,r=potions.length-1,ans=-1;
            while(l<=r)
            {
                int mid=(l+r)/2;
                if((long)s*potions[mid]<success)
                    l=mid+1;
                else
                {
                    ans=mid;
                    r=mid-1;
                }
            }
            a[j]=(ans==-1)?0:potions.length-ans;
        }
        return a;
    }
}