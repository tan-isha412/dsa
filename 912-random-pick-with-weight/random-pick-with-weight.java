class Solution {
    int[] psum;
    int total;
    Random ran;
    public Solution(int[] w) {
        ran=new Random();
        psum=new int[w.length];
        for(int i=0;i<w.length;i++)
        {
            total+=w[i];
            psum[i]=total;
        }
    }
    
    public int pickIndex() {
        int rand=ran.nextInt(total)+1;
        int l=0,r=psum.length-1;
        while(l<r)
        {
            int mid=(l+r)/2;
            if(psum[mid]<rand)
                l=mid+1;
            else
                r=mid;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */