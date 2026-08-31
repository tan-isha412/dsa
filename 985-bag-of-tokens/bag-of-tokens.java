class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score=0,maxscore=0;
        int l=0,r=tokens.length-1;
        Arrays.sort(tokens);
        while(l<=r)
        {
            if(tokens[l]<=power)
            {
                score++;
                power-=tokens[l];
                l++;
                maxscore=Math.max(maxscore,score);

            }
            else if(score>0)
                {
                    power+=tokens[r];
                    score--;
                    r--;
                }
            else
                break;
        }
        return maxscore;
    }
}