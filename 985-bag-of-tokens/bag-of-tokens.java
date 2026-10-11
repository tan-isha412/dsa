class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score=0,maxms=0;
        int l=0,r=tokens.length-1;
        while(l<=r)
        {
            if(tokens[l]<=power)
            {
                power-=tokens[l];
                score++;
                l++;
            }
            else if(score>0)
                {
                    power+=tokens[r];
                    score--;
                    r--;
                }
            else
                break;
            maxms=Math.max(maxms,score);
        }
        return maxms;
    }
}