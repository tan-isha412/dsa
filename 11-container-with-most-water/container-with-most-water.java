class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,maxarea=0;
        while(l<r)
        {
            int currline=Math.min(height[l],height[r]);
            maxarea=Math.max(maxarea,currline*(r-l));
            if(height[l]<height[r]) l++;
            else r--;
        }
        return maxarea;
    }
}