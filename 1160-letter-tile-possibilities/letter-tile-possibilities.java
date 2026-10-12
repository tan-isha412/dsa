class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq=new int[26];
        for(char ch:tiles.toCharArray())
            freq[ch-'A']++;
        return backtrack(freq);
    }
    public int backtrack(int[] c)
    {
        int sum=0;
        for(int i=0;i<26;i++)
        {
            if(c[i]==0) continue;
            sum++;
            c[i]--;
            sum+=backtrack(c);
            c[i]++;
        }
        return sum;
    }
}