class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int minm=(Math.min(matrix.length,matrix[0].length)+1)/2;
        for(int i=0;i<minm;i++)
        {
            for(int j=i;j<matrix[0].length-i;j++)
                ans.add(matrix[i][j]);
            for(int j=i+1;j<matrix.length-i;j++)
                ans.add(matrix[j][matrix[0].length-i-1]);
            if(matrix.length>2*i+1)
            {
                for(int j=matrix[0].length-2-i;j>=i;j--)
                    ans.add(matrix[matrix.length-i-1][j]);
            }
            if(matrix[0].length>2*i+1)
            {
                for(int j=matrix.length-2-i;j>i;j--)
                    ans.add(matrix[j][i]);
            }
        }
        return ans;
    }
}