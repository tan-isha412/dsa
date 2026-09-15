class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0] || target>matrix[matrix.length-1][matrix[0].length-1]) return false;
        int l=0,r=matrix.length-1;
        int row=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target)
            {
                row=mid;
                break;
            }
            else if(matrix[mid][0]>target)
                r=mid-1;
            else
                l=mid+1;
        }
        if(row==-1) return false;
        l=0;
        r=matrix[0].length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]>target)
                r=mid-1;
            else
                l=mid+1;
        }
        return false;
    }
}