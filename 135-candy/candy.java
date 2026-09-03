class Solution {
    public int candy(int[] ratings) {
        int[] c=new int[ratings.length];
        Arrays.fill(c,1);
        for(int i=0;i<ratings.length-1;i++)
        {
            if(ratings[i]<ratings[i+1])
                c[i+1]=c[i]+1;
        }
        for(int i=ratings.length-1;i>0;i--)
        {
            if(ratings[i]<ratings[i-1])
            {
                c[i-1]=Math.max(c[i-1],c[i]+1);
            }
        }
        int sum=0;
        for(int ca:c)
            sum+=ca;
        return sum;
    }
}