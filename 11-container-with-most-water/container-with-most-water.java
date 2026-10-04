class Solution {
    public int maxArea(int[] height) {
        int lmax=Integer.MIN_VALUE;
        int rmax=lmax;
        int l=0,r=height.length-1,maxarea=0;
        while(l<r)
        {
            int curarea=0;
            if(height[l]>=height[r])
            {
                if(height[r]>rmax)
                {
                    rmax=height[r];
                    curarea=rmax*(r-l);
                }
                else
                    curarea=(rmax-height[r])*(r-l);
                r--;
            }
            else
            {
                if(height[l]>lmax)
                {
                    lmax=height[l];
                    curarea=lmax*(r-l);
                }
                else
                    curarea=(lmax-height[l])*(r-l);
                l++;
            }
            maxarea=Math.max(maxarea,curarea);
        }
        return maxarea;
    }
}