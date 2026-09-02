class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int m:matchsticks)
            sum+=m;
        if(sum%4!=0) return false;
        sum/=4;
        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length / 2; i++) 
        {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }

        if(matchsticks[0]>sum) return false;
        int[] sides=new int[4];
        return (backtrack(0,sides,sum,matchsticks));
    }
    public boolean backtrack(int start,int[] sides,int sum,int[] matchsticks)
    {
        if(start==matchsticks.length) return true;
        int curr=matchsticks[start];
        for(int i=0;i<4;i++)
        {
            if(sides[i]+curr<=sum)
            {
                sides[i]+=curr;
                if(backtrack(start+1,sides,sum,matchsticks))
                    return true;
                sides[i]-=curr;
            }
            if(sides[i]==0) break;
        }
        return false;
    }
}