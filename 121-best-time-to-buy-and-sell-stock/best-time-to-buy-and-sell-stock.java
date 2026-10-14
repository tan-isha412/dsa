class Solution {
    public int maxProfit(int[] prices) {
        int minm=prices[0];
        int maxp=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>=minm)
            {
                if(maxp<prices[i]-minm)
                    maxp=prices[i]-minm;
            }
            else
                minm=prices[i];
        }
        return maxp;
    }
}