class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l=new ArrayList<>();
        int idx=(Math.min(matrix.length,matrix[0].length)+1)/2;
        for(int i=0;i<idx;i++)
        {
            for(int j=i;j<matrix[0].length-i;j++)
                l.add(matrix[i][j]);
            for(int j=i+1;j<matrix.length-i;j++)
                l.add(matrix[j][matrix[0].length-i-1]);
            if(2*i<matrix.length-1)
            {
                for(int j=matrix[0].length-2-i;j>=i;j--)
                    l.add(matrix[matrix.length-1-i][j]);
            }
            if(2*i<matrix[0].length-1)
            {
                for(int j=matrix.length-2-i;j>i;j--)
                    l.add(matrix[j][i]);
            }
        }
        return l;
    }
}