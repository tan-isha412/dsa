class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len=cardPoints.length;
        int tot=0;
        for(int p:cardPoints)
            tot+=p;
        int want=len-k;
        if(want==0) return tot;
        int sum=0;
        for(int i=0;i<want;i++)
            sum+=cardPoints[i];
        int minsum=sum;
        for(int i=want;i<cardPoints.length;i++)
        {
            sum+=cardPoints[i]-cardPoints[i-want];
            minsum=Math.min(minsum,sum);
        }
        return tot-minsum;
    }
}