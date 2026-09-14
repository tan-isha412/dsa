class Solution {
    public int maxProfit(int[] prices) {
        int hold=-prices[0],soldtoday=0,resttoday=0;
        for(int i=1;i<prices.length;i++)
        {
            int soldyester=soldtoday;
            hold=Math.max(hold,resttoday-prices[i]);
            soldtoday=hold+prices[i];
            resttoday=Math.max(resttoday,soldyester);
        }
        return Math.max(soldtoday,resttoday);
    }
}